package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
	RECURSO_NAO_ENCONTRADA("/recurso-nao-encontrada", "Recurso não encontrada"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade está em uso"),
	ERRO_NEGOCIO("/ERRO-negocio", "Violação de egra de negócio"),
	PARAMETRO_INVALIDO("/parametro-invalido","Parâmetro Inválido");
	
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://localhost:8080" + path;
		this.title = title;
	}
	
	

}
