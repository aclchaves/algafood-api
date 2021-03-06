package com.algaworks.algafood.api.model.input.id;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoIdInput {
	
	@ApiModelProperty(example = "1")
	@NotNull
	private Long id;

}
