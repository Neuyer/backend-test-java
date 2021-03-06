package br.com.estacionamento.controller;

import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {
		
	@Autowired
	private EstabelecimentoService estabelecimentoService;


	@GetMapping
	public List<Estabelecimento> buscaTodos() {
		return estabelecimentoService.buscaTodos();
	}

	@GetMapping("/{cnpj}")
	public ResponseEntity<Estabelecimento> buscaEstabelecimentoPorCnpj(@PathVariable String cnpj) {
		return estabelecimentoService.buscaEstabelecimentoPorCnpj(cnpj);

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

	@DeleteMapping(value = { "/{cnpj}" })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String delete(@PathVariable String cnpj) {
		return estabelecimentoService.delete(cnpj);
	}
}
