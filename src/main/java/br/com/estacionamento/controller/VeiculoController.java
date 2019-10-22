package br.com.estacionamento.controller;


import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping //essa anotação invoca o metodo com base na uri
	public List<Veiculo> findAll() {
		return veiculoService.findAll();
	}

	@GetMapping(value="/{placa}")
	ResponseEntity<Veiculo> buscaPorPlaca(@PathVariable String placa){return veiculoService.buscaPorPlaca(placa);}

	@PostMapping
	public Veiculo create(@RequestBody Veiculo veiculo){
	   return veiculoService.create(veiculo);
	}
	
	@PutMapping(value="/{placa}")
	public ResponseEntity<Veiculo> update(@PathVariable("placa") String placa,
	                                      @RequestBody Veiculo veiculo) {
	   return veiculoService.update(placa, veiculo);
	}
	
	@DeleteMapping(path ={"/{placa}"})
	public ResponseEntity<?> delete(@PathVariable String placa) {
	   return veiculoService.delete(placa);
	}
}
