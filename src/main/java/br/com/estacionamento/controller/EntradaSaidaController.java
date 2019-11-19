package br.com.estacionamento.controller;

import br.com.estacionamento.service.EntradaSaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradasaida")
public class EntradaSaidaController {

	@Autowired
	private EntradaSaidaService entradaSaidaService;

	@PostMapping
	public ResponseEntity<?> registraEvento(@RequestParam("cnpj") String cnpj, @RequestParam("placa") String placa) throws Exception {
		entradaSaidaService.registraEvento(cnpj, placa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
