package br.com.estacionamento.controller;

import br.com.estacionamento.domain.entity.MENSAGENS;
import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;
import br.com.estacionamento.application.EstabelecimentoService;
import br.com.estacionamento.domain.entity.estabelecimento.EstabelecimentoCadastroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/{id}")
	public ResponseEntity<Estabelecimento> findById(@PathVariable long id) {
		Optional<Estabelecimento> estabelecimentoOpt = estabelecimentoService.findById(id);
		return estabelecimentoOpt.map(estabelecimento -> new ResponseEntity<>(estabelecimento, HttpStatus.OK))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Estabelecimento> create(@RequestBody EstabelecimentoCadastroDto estabelecimentoCadastroDto) {
		return new ResponseEntity<>(estabelecimentoService.create(estabelecimentoCadastroDto), HttpStatus.CREATED);
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
