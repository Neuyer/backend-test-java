package br.com.estacionamento.controller;

import br.com.estacionamento.service.EntradaSaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradas")
public class EntradaSaidaController {
	@Autowired
	private EntradaSaidaService controle;

	@PostMapping
	public void  insereVeiculo(@RequestParam("cnpj") String cnpj, @RequestParam("placa") String placa) throws Exception {
			controle.registraEntrada(cnpj, placa);
	}

	@PutMapping
	public void  removeVeiculo(@RequestParam("placa") String placa) throws Exception {
		controle.registraSaida(placa);
	}
}
