package br.com.estacionamento.service;

import java.util.List;

import br.com.estacionamento.enums.Mensagens;
import br.com.estacionamento.exceptions.EstabelecimentoNaoEncontradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.repository.EstabelecimentoRepository;
@Service
public class EstabelecimentoService {
	private Mensagens mensagens;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	public EstabelecimentoService(EstabelecimentoRepository repo) {
		this.estabelecimentoRepository = repo;
	}
	
	public List<Estabelecimento> buscaTodos() {
		return estabelecimentoRepository.findAll();
	}

	public ResponseEntity<Estabelecimento> buscaEstabelecimentoPorId(@PathVariable long id) {
		return estabelecimentoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Estabelecimento> buscaEstabelecimentoPorCnpj(@PathVariable("cnpj") String cnpj) {
		return estabelecimentoRepository.findByCnpj(cnpj).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	public Estabelecimento create(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	public ResponseEntity<Estabelecimento> update(long id, Estabelecimento estabelecimento) {
		return estabelecimentoRepository.findById(id).map(record -> {
			record.setNome(estabelecimento.getNome());
			record.setCnpj(estabelecimento.getCnpj());
			record.setTelefone(estabelecimento.getTelefone());
			record.setEndereco(estabelecimento.getEndereco());
			record.setQtVagasCarros(estabelecimento.getQtVagasCarros());
			record.setQtVagasMotos(estabelecimento.getQtVagasMotos());
			Estabelecimento updated = estabelecimentoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public String delete(String cnpj) {
		Estabelecimento estabelecimento =  estabelecimentoRepository.findByCnpj(cnpj).orElseThrow(EstabelecimentoNaoEncontradoException::new);
		estabelecimentoRepository.delete(estabelecimento);
		return mensagens.ESTABELECIMENTO_DELETADO_SUCESSO.getDescricao();
	}
}
