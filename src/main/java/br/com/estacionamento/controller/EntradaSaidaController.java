package br.com.estacionamento.controller;

import br.com.estacionamento.model.EntradaSaida;
import br.com.estacionamento.model.EntradaSaidaDTO;
import br.com.estacionamento.service.EntradaSaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradas")
public class EntradaSaidaController {
	@Autowired
	private EntradaSaidaService controle;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntradaSaida insereVeiculo(@RequestBody EntradaSaidaDTO entrada) throws Exception {
			return controle.registraEntrada(entrada);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void  removeVeiculo(@RequestParam("idEntrada") Long idEntrada) throws Exception {
		controle.registraSaida(idEntrada);
	}
}
