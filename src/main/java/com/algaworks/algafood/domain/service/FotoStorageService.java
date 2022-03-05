package com.algaworks.algafood.domain.service;

import java.io.InputStream;

import lombok.Builder;
import lombok.Getter;

public interface FotoStorageService {
	
	public void amazenar(NovaFoto novaFoto);
	
	@Builder
	@Getter
	class NovaFoto{
		private String nomeArquivo;
		private InputStream inputStream;
	}

}
