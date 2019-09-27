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
	
	@RequestMapping(method=RequestMethod.GET) //essa anotação invoca o metodo com base na uri
	public List<Veiculo> findAll() {
		return veiculoService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscaPorId(@PathVariable long id){
	   return veiculoService.buscaPorId(id);
	}

	@GetMapping("/?placa={placa}")
	ResponseEntity<Veiculo> buscaPorPlaca(@PathVariable String placa){return veiculoService.buscaPorPlaca(placa);}

	@PostMapping
	public Veiculo create(@RequestBody Veiculo veiculo){
	   return veiculoService.create(veiculo);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable("id") long id,
	                                      @RequestBody Veiculo veiculo) {
	   return veiculoService.update(id, veiculo);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long id) {
	   return veiculoService.delete(id);
	}
}
