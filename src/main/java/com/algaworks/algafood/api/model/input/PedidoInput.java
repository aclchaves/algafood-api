package com.algaworks.algafood.api.model.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algaworks.algafood.api.model.input.id.FormaPagamentoIdInput;
import com.algaworks.algafood.api.model.input.id.RestauranteIdInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoInput {
	
	@Valid
	@NotNull	
	private RestauranteIdInput restaurante;
	
	@Valid
	@NotNull	
	private FormaPagamentoIdInput formaPagamento;
	
	@Valid
	@NotNull	
	private EnderecoInput enderecoEntrega;
	
	@Valid
	@Size(min = 1)
	@NotNull
	List<ItemPedidosInput> itens;
}
