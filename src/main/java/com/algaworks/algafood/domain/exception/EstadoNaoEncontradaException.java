package com.algaworks.algafood.domain.exception;

public class EstadoNaoEncontradaException extends EntidadeNaoEncontradaException{

	private static final long serialVersionUID = 1L;
	
	
	public EstadoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public EstadoNaoEncontradaException(Long estadoId) {
		this(String.format("Não existe cadastro de estado com código %d", estadoId));
	}
}
	
	
	
	