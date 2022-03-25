package com.algaworks.algafood.domain.service;

import java.io.InputStream;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

public interface FotoStorageService {
	
	public InputStream recuperar(String nomeArquivo);
	
	public void amazenar(NovaFoto novaFoto);
	
	public void remover(String nomeArquivo);
	
	default void Substituir(String nomeArquivoAntigo, NovaFoto novaFoto) {
		this.amazenar(novaFoto);
		
		if(nomeArquivoAntigo != null) {
			this.remover(nomeArquivoAntigo);
		}
		
	}
	
	default String gerarNomeArquivo(String nomeOriginal) {
		return UUID.randomUUID().toString() + "_" + nomeOriginal;
	}	
	
	@Builder
	@Getter
	class NovaFoto{
		private String nomeArquivo;
		private String contentType;
		private InputStream inputStream;
	}

}
