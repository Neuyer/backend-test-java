package br.com.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.repository.EstabelecimentoRepository;
@Service
public class EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository repository;

	public EstabelecimentoService(EstabelecimentoRepository repo) {
		this.repository = repo;
	}
	
	public List<Estabelecimento> buscaTodos() {
		return repository.findAll();
	}
	
	public ResponseEntity<Estabelecimento> entra(@PathVariable long id) {
		    ResponseEntity<Estabelecimento> e = buscaEstabelecimentoPorId(id);
		return e;
	}
	
	public ResponseEntity<Estabelecimento> buscaEstabelecimentoPorId(@PathVariable long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	 
	}

	public Estabelecimento create(@RequestBody Estabelecimento estabelecimento) {
		return repository.save(estabelecimento);
	}

	public ResponseEntity<Estabelecimento> update(@PathVariable("id") long id,
			@RequestBody Estabelecimento estabelecimento) {
		return repository.findById(id).map(record -> {
			record.setNome(estabelecimento.getNome());
			record.setCnpj(estabelecimento.getCnpj());
			record.setTelefone(estabelecimento.getTelefone());
			record.setEndereco(estabelecimento.getEndereco());
			record.setQtVagasCarros(estabelecimento.getQtVagasCarros());
			record.setQtVagasMotos(estabelecimento.getQtVagasMotos());
			Estabelecimento updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> delete(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
