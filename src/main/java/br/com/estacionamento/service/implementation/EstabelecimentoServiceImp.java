package br.com.estacionamento.service.implementation;

import java.util.List;
import br.com.estacionamento.exceptions.EstabelecimentoNaoEncontradoException;
import br.com.estacionamento.service.EstabelecimentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import javax.transaction.Transactional;

@Service
public class EstabelecimentoServiceImp implements EstabelecimentoService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	public List<Estabelecimento> findAll() {
		return estabelecimentoRepository.findAll();
	}

	public Estabelecimento findByCnpj(String cnpj) {
		return new Estabelecimento();
	}

	@Transactional
	public Estabelecimento create(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	@Transactional
	public Estabelecimento update(Estabelecimento estabelecimento) {
		Estabelecimento estabelecimentoUpdate =  estabelecimentoRepository
				.findByCnpj(estabelecimento.getCnpj())
				.orElseThrow(EstabelecimentoNaoEncontradoException::new);

		estabelecimentoUpdate.setNome(estabelecimento.getNome());
		estabelecimentoUpdate.setCnpj(estabelecimento.getCnpj());
		estabelecimentoUpdate.setTelefone(estabelecimento.getTelefone());
		estabelecimentoUpdate.setEndereco(estabelecimento.getEndereco());
		estabelecimentoUpdate.setQtVagasCarros(estabelecimento.getQtVagasCarros());
		estabelecimentoUpdate.setQtVagasMotos(estabelecimento.getQtVagasMotos());
		return estabelecimentoUpdate;
	}

	@Transactional
	public void delete(String cnpj) {
		Estabelecimento estabelecimento =  estabelecimentoRepository.findByCnpj(cnpj).orElseThrow(EstabelecimentoNaoEncontradoException::new);
		estabelecimentoRepository.delete(estabelecimento);
	}
}
