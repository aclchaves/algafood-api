package com.algaworks.algafood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.repository.PedidoRepository;

@Service
public class FluxoPedidoService {
	
	@Autowired
	private EmissaoPedidoService emissaoPedido;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Transactional
	public void confirmar(String codigoPedido) {
		Pedido pedido = emissaoPedido.buscarOuFalha(codigoPedido);
		pedido.confirmar();
		
		pedidoRepository.save(pedido);
		
//		var mensagem = Mensagem.builder()
//				.assunto(pedido.getRestaurante().getNome() + " - Pedido confirmado")
//				.corpo("pedido-confirmado.html")
//				.variavel("pedido", pedido)
//				.destinatario(pedido.getCliente().getEmail())
//				.build();
		
//		envioEmail.enviar(mensagem);
				
	}
	
	@Transactional
	public void entregar(String  codigoPedido) {
		Pedido pedido = emissaoPedido.buscarOuFalha(codigoPedido);
		pedido.entregar();		
	}
	
	@Transactional
	public void cancelar(String codigoPedido) {
		Pedido pedido = emissaoPedido.buscarOuFalha(codigoPedido);
		pedido.cancelar();
	}
}
