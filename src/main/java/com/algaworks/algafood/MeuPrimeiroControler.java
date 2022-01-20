package com.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

@Controller
public class MeuPrimeiroControler {
	
	private AtivacaoClienteService ativacaoClienteService;	
	
	public MeuPrimeiroControler(AtivacaoClienteService ativacaoClienteService) {	
		this.ativacaoClienteService = ativacaoClienteService;		
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		Cliente joao = new Cliente("Joao", "joao@xyz.com", "3499998888");		
		ativacaoClienteService.ativar(joao);
		
		
		return "Hello2!";
	}

}
