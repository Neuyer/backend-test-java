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
import org.springframework.web.bind.annotation.RestController;

import br.com.estacionamento.estacionamento.model.Estabelecimento;
import br.com.estacionamento.estacionamento.repository.EstabelecimentoRepository;
import br.com.estacionamento.estacionamento.service.*;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {
		
		
		private EstabelecimentoRepository repository;
		
		EstabelecimentoController(EstabelecimentoRepository estabelecimentoRepository){
			this.repository = estabelecimentoRepository;
		}
		
		@GetMapping //essa anotação invoca o metodo com base na uri
		public List<Estabelecimento> buscaTodos() {
			return repository.findAll();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Estabelecimento> buscaEstabelecimentoPorId(@PathVariable long id){
		   return repository.findById(id)
		           .map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());
		}
		
		
		@PostMapping
		public Estabelecimento create(@RequestBody Estabelecimento estabelecimento){
		   return repository.save(estabelecimento);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Estabelecimento> update(@PathVariable("id") long id,
		                                      @RequestBody Estabelecimento estabelecimento) {
		   return repository.findById(id)
		           .map(record -> {
		               record.setNome(estabelecimento.getNome());
		               record.setCnpj(estabelecimento.getCnpj());
		               record.setTelefone(estabelecimento.getTelefone());
		               record.setEndereco(estabelecimento.getEndereco());
		               record.setVeiculos(estabelecimento.getVeiculos());
		               record.setQtVagasCarros(estabelecimento.getQtVagasCarros());
		               record.setQtVagasMotos(estabelecimento.getQtVagasMotos());
		               Estabelecimento updated = repository.save(record);
		               return ResponseEntity.ok().body(updated);
		           }).orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping(path ={"/estabelecimentos/{id}"})
		public ResponseEntity<?> delete(@PathVariable long id) {
		   return repository.findById(id)
		           .map(record -> {
		               repository.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		}
	}


