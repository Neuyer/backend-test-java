package br.com.estacionamento.controller;

import br.com.estacionamento.enums.MENSAGENS;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
		
	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@GetMapping
	public ResponseEntity<List<Estabelecimento>> findAll() {
		return new ResponseEntity<>(estabelecimentoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{cnpj}")
	public ResponseEntity<Estabelecimento> findByCnpj(@PathVariable String cnpj) {
		Estabelecimento estabelecimento = estabelecimentoService.findByCnpj(cnpj);
		return new ResponseEntity<>(estabelecimento, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Estabelecimento> create(@RequestBody Estabelecimento estabelecimento) {
		return new ResponseEntity<>(estabelecimentoService.create(estabelecimento), HttpStatus.CREATED);
	}

	@PutMapping("/{cnpj}")
	public ResponseEntity<Estabelecimento> update(@PathVariable String cnpj,
	  		@RequestBody Estabelecimento estabelecimento) {
		estabelecimento.setCnpj(cnpj);
		return new ResponseEntity<>(estabelecimento, HttpStatus.OK);
	}

	@DeleteMapping("/{cnpj}")
	public ResponseEntity<String> delete(@PathVariable String cnpj) {
		estabelecimentoService.delete(cnpj);
		return new ResponseEntity<>(MENSAGENS.ESTABELECIMENTO_DELETADO_SUCESSO.getDescricao(), HttpStatus.OK);
	}
}
