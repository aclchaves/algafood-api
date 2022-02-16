package com.algaworks.algafood.domain.mixin;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GrupoMixin {
	
	@JsonIgnore
	List<Permissao> permissoes = new ArrayList<>();

}
