package com.algaworks.algafood.api.controller;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import com.algaworks.algafood.api.assembler.FormaPagamentoInputDisassembler;
import com.algaworks.algafood.api.assembler.FormaPagamentoModelAssembler;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;
import com.algaworks.algafood.domain.exception.FormaPagamentoNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRespository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {	
	
	@Autowired
	FormaPagamentoRespository formaPagamentoRespository;
	
	@Autowired
	CadastroFormaPagamentoService cadastroFormaPagamento;
	
	@Autowired
	FormaPagamentoModelAssembler formaPagamentoModelAssembler;
	
	@Autowired
	FormaPagamentoInputDisassembler formaPagamentoInputDisassembler;
	
	
	@GetMapping
	public ResponseEntity<List<FormaPagamentoModel>> listar(ServletWebRequest request){
		ShallowEtagHeaderFilter.disableContentCaching(request.getRequest());
		
		String eTag = "0";
		
		OffsetDateTime dataUltimaAtualizacao = formaPagamentoRespository.getDataUltimaAtualizacao();
		
		if(dataUltimaAtualizacao != null) {
			eTag = String.valueOf(dataUltimaAtualizacao.toEpochSecond());
		}
		
		//j?? temos condi????es de saber se continua ou n??o o processamento
		if(request.checkNotModified(eTag)) {
			return null;
		}
		
		
		List<FormaPagamento> todasFormasPagamento = formaPagamentoRespository.findAll();
		
		List<FormaPagamentoModel> formasPagamentosModel = formaPagamentoModelAssembler.
				toCollectionModel(todasFormasPagamento);
		
		return ResponseEntity.ok()				
				.cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS).cachePublic())			
				.eTag(eTag)
				.body(formasPagamentosModel);
		
	}
	
	@GetMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamentoModel> buscar (ServletWebRequest request,
			@PathVariable Long formaPagamentoId) {
		
		ShallowEtagHeaderFilter.disableContentCaching(request.getRequest());
		
		String eTag = "0";
		
		OffsetDateTime dataAtualizacao = formaPagamentoRespository
				.getDataAtualizacaoById(formaPagamentoId);
		
		if(dataAtualizacao != null) {
			eTag = String.valueOf(dataAtualizacao.toEpochSecond());
		}
		
		//j?? temos condi????es de saber se continua ou n??o o processamento
		if(request.checkNotModified(eTag)) {
			return null;
		}
		
		try {
			
			FormaPagamento formaPagamento = cadastroFormaPagamento
					.buscarOuFalhar(formaPagamentoId);
			
			FormaPagamentoModel formaPagamentoModel = formaPagamentoModelAssembler
					.toModel(formaPagamento);
			
			return ResponseEntity.ok()
					.cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS))
					.eTag(eTag)
					.body(formaPagamentoModel);
			
		} catch (FormaPagamentoNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamentoModel adicionar (@RequestBody @Valid 
			FormaPagamentoInput formaPagamentoInput ) {
		
		FormaPagamento formaPagamento = formaPagamentoInputDisassembler.toDomainObject(formaPagamentoInput);
		
		formaPagamento = cadastroFormaPagamento.salvar(formaPagamento);
		
		return formaPagamentoModelAssembler.toModel(formaPagamento);
	}
	
	@PutMapping("/{formaPagamentoId}")
	public FormaPagamentoModel atualizar( @PathVariable Long formaPagamentoId, 
			@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {		
			
			FormaPagamento formaPagamentoAtual = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);
						
			formaPagamentoInputDisassembler.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);
			
			formaPagamentoAtual = cadastroFormaPagamento.salvar(formaPagamentoAtual);
			
			return formaPagamentoModelAssembler.toModel(formaPagamentoAtual);		
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir (@PathVariable Long formaPagamentoId) {		
		cadastroFormaPagamento.excluir(formaPagamentoId);		
	}

}
