package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRespository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRespository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> todas() {		
		return manager.createQuery("from FormaPagamento", FormaPagamento.class)
				.getResultList();
	}

	@Override
	public FormaPagamento porId(Long id) {	
		return manager.find(FormaPagamento.class, id);
	}

	@Transactional
	@Override
	public FormaPagamento adicionar(FormaPagamento formaPagamento) {		
		return manager.merge(formaPagamento);
	}

	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = porId(formaPagamento.getId());
		manager.remove(formaPagamento);
		
	}

}
