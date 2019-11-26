package br.com.estacionamento.application.implementation;

import java.util.List;
import java.util.Optional;
import br.com.estacionamento.core.exception.EstabelecimentoException;
import br.com.estacionamento.application.EstabelecimentoService;
import br.com.estacionamento.domain.entity.Endereco;
import br.com.estacionamento.domain.entity.estabelecimento.EstabelecimentoCadastroDto;
import br.com.estacionamento.domain.repository.EnderecoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;
import br.com.estacionamento.domain.repository.EstabelecimentoRepository;
import javax.transaction.Transactional;

@Service
public class EstabelecimentoServiceImp implements EstabelecimentoService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public List<Estabelecimento> findAll() {
		return estabelecimentoRepository.findAll();
	}

	public  Optional<Estabelecimento> findById(long id) { return estabelecimentoRepository.findById(id); }
	public Estabelecimento findByCnpj(String cnpj) {
		return new Estabelecimento();
	}

	@Transactional
	public Estabelecimento create(EstabelecimentoCadastroDto estabelecimentoCadastroDto) {
		Estabelecimento estabelecimento = new Estabelecimento(estabelecimentoCadastroDto);
		Endereco endereco = new Endereco(estabelecimentoCadastroDto);

		enderecoRepository.save(endereco);

		return estabelecimentoRepository.save(estabelecimento);
	}

	@Transactional
	public Estabelecimento update(Estabelecimento estabelecimento) {
		Estabelecimento estabelecimentoUpdate =  estabelecimentoRepository
				.findByCnpj(estabelecimento.getCnpj())
				.orElseThrow(EstabelecimentoException::new);

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
		Estabelecimento estabelecimento =  estabelecimentoRepository.findByCnpj(cnpj).orElseThrow(EstabelecimentoException::new);
		estabelecimentoRepository.delete(estabelecimento);
	}
}
