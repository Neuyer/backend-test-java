package br.com.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.service.EstabelecimentoService;
@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {
		
	@Autowired
	private EstabelecimentoService estabelecimentoService;


	@RequestMapping(method=RequestMethod.GET)
	public List<Estabelecimento> buscaTodos() {
		return estabelecimentoService.buscaTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estabelecimento> buscaEstabelecimentoPorId(@PathVariable long id) {
		return estabelecimentoService.buscaEstabelecimentoPorId(id);
	 
	}
	
	@PostMapping
	public Estabelecimento create(@RequestBody Estabelecimento estabelecimento) {
		return estabelecimentoService.create(estabelecimento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estabelecimento> update(@PathVariable("id") long id,
			@RequestBody Estabelecimento estabelecimento) {
		return estabelecimentoService.update(id, estabelecimento);
	}

	@DeleteMapping(path = { "/estabelecimentos/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return estabelecimentoService.delete(id);
	}
}
