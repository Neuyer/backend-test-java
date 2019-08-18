package br.com.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.service.EntradaSaidaService;

@RestController
@RequestMapping("estabelecimentos/entrada")
public class EntradaSaidaController {
	@Autowired
	private EntradaSaidaService controle;
	
	@PostMapping("/eId/vId")
	public void  insereVeiculo(@PathVariable("eId") Long eId, @PathVariable("vId") Long vId) {
		controle.insereVeiculo(eId, vId);
	}
}
