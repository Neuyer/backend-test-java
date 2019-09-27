package br.com.estacionamento.controller;

import br.com.estacionamento.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entradas")
public class EntradaSaidaController {
	@Autowired
	private SaidaService controle;

//	haushdkashdkjsahku
	@PostMapping(path="/?cnpj={cnpj}/?placa={placa}")
	public void  insereVeiculo(@PathVariable("cnpj") String cnpj, @PathVariable("placa") String placa) throws Exception {
			controle.insereVeiculo(cnpj, placa);
	}
}
