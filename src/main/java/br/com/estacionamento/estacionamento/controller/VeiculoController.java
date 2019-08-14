package br.com.estacionamento.estacionamento.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.estacionamento.model.Veiculo;
import br.com.estacionamento.estacionamento.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	private VeiculoRepository repository;
	
	VeiculoController(VeiculoRepository veiculoRepository){
		this.repository = veiculoRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET) //essa anotação invoca o metodo com base na uri
	public List<Veiculo> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculo> buscaPorId(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public Veiculo create(@RequestBody Veiculo veiculo){
	   return repository.save(veiculo);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Veiculo> update(@PathVariable("id") long id,
	                                      @RequestBody Veiculo veiculo) {
	   return repository.findById(id)
	           .map(record -> {
	               record.setMarca(veiculo.getMarca());
	               record.setModelo(veiculo.getModelo());
	               record.setCor(veiculo.getCor());
	               record.setPlaca(veiculo.getPlaca());
	               record.setTipo(veiculo.getTipo());
	               Veiculo updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
