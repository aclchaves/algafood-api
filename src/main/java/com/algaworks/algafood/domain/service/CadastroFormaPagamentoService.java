package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.FormaPagamentoNaoEncontradaException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRespository;

@Service
public class CadastroFormaPagamentoService {
	
	private static final String MSG_FORMA_PAGAMENTO_EM_USO = 
			"Forma Pagamento de código %d  não pode ser removida, pois está em uso";

	@Autowired
	FormaPagamentoRespository formaPagamentoRespository;
	
	@Transactional
	public FormaPagamento salvar(FormaPagamento formaPagamento) {		
		return formaPagamentoRespository.save(formaPagamento);
	}
	
	@Transactional
	public void excluir(Long formaPamentoId) {
		try {
			formaPagamentoRespository.deleteById(formaPamentoId);
			formaPagamentoRespository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new FormaPagamentoNaoEncontradaException(formaPamentoId);
			
		}catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format(MSG_FORMA_PAGAMENTO_EM_USO, formaPamentoId));
		}
	}	
	
	public FormaPagamento buscarOuFalhar(Long formaPagamentoId) {
		
		return formaPagamentoRespository.findById(formaPagamentoId)
				.orElseThrow( () -> new FormaPagamentoNaoEncontradaException(
						formaPagamentoId));
	}
}
