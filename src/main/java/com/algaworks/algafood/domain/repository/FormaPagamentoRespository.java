package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRespository {
	
	public List<FormaPagamento> todas();	
	public FormaPagamento porId(Long id);
	public FormaPagamento adicionar(FormaPagamento formaPagamento);
	public void remover(FormaPagamento formaPagamento);

}
