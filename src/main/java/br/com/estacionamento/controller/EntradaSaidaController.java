package br.com.estacionamento.controller;

import br.com.estacionamento.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradas")
public class EntradaSaidaController {
	@Autowired
	private SaidaService controle;

	@PostMapping
	public void  insereVeiculo(@RequestParam("cnpj") String cnpj, @RequestParam("placa") String placa) throws Exception {
			controle.insereVeiculo(cnpj, placa);
	}
}
