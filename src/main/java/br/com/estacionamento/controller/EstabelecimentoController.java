package br.com.estacionamento.controller;

import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.EstabelecimentoDTO;
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
	@ResponseBody
	public Estabelecimento buscaEstabelecimentoPorCnpj(@PathVariable String cnpj) throws Exception {
		return estabelecimentoService.buscaEstabelecimentoPorCnpj(cnpj);
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Estabelecimento create(@RequestBody Estabelecimento estabelecimento) throws Exception {
		return estabelecimentoService.create(estabelecimento);
	}

	@PutMapping("/{cnpj}")
	@ResponseBody
	public Estabelecimento update(@PathVariable("cnpj") String cnpj,
			@RequestBody EstabelecimentoDTO estabelecimento) throws Exception {
		return estabelecimentoService.update(cnpj, estabelecimento);
	}

	@DeleteMapping(value = { "/{cnpj}" })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String delete(@PathVariable("cnpj") String cnpj) {
		return estabelecimentoService.delete(cnpj);
	}
}
