package com.algaworks.algafood.core.jackson;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.mixin.CidadeMixin;
import com.algaworks.algafood.domain.mixin.CozinhaMixin;
import com.algaworks.algafood.domain.mixin.GrupoMixin;
import com.algaworks.algafood.domain.mixin.ProdutoMixin;
import com.algaworks.algafood.domain.mixin.RestauranteMixin;
import com.algaworks.algafood.domain.mixin.UsuarioMixin;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.model.Usuario;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixinModule extends SimpleModule{
	
	private static final long serialVersionUID = 1L;
	
	public JacksonMixinModule() {
		setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
		setMixInAnnotation(Grupo.class, GrupoMixin.class);
		setMixInAnnotation(Produto.class, ProdutoMixin.class);
		setMixInAnnotation(Usuario.class, UsuarioMixin.class);
	}

}
