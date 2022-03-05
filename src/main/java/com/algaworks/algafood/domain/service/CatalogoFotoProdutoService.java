package com.algaworks.algafood.domain.service;

import java.io.InputStream;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.repository.ProdutoRepository;
import com.algaworks.algafood.domain.service.FotoStorageService.NovaFoto;

@Service
public class CatalogoFotoProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FotoStorageService fotoStorage;

	@Transactional
	public FotoProduto salvar(FotoProduto foto, InputStream dadosArquivo) {
		Long resauranteId = foto.getRestauranteId();
		Long produtoId = foto.getProduto().getId();
		String nomeNovoArquivo = fotoStorage.gerarNomeArquivo(foto.getNomeArquivo());
		
		Optional<FotoProduto> fotoExistente = produtoRepository
				.findFotoById(resauranteId, produtoId);
		if(fotoExistente.isPresent()) {
			produtoRepository.delete(fotoExistente.get());
		}
		
		foto.setNomeArquivo(nomeNovoArquivo);
		foto = produtoRepository.save(foto);
		produtoRepository.flush();
		
		NovaFoto novaFoto = NovaFoto.builder()
				.nomeArquivo(foto.getNomeArquivo())
				.inputStream(dadosArquivo)
				.build();
		
		fotoStorage.amazenar(novaFoto);
		
		return foto;
	}
}
