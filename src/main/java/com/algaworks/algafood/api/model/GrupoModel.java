package com.algaworks.algafood.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoModel {
	
	
	private Long id;
	private String nome;
	
	@JsonIgnore
	List<PermissaoModel> permissoes = new ArrayList<>();

}
