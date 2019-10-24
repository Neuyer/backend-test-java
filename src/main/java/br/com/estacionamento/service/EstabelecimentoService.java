package br.com.estacionamento.service;

import br.com.estacionamento.enums.Mensagens;
import br.com.estacionamento.exceptions.ErroAoRegistrarException;
import br.com.estacionamento.exceptions.EstabelecimentoNaoEncontradoException;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.EstabelecimentoDTO;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
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

	public Estabelecimento buscaEstabelecimentoPorCnpj(@PathVariable("cnpj") String cnpj) {
		return estabelecimentoRepository.findByCnpj(cnpj).orElseThrow(EstabelecimentoNaoEncontradoException::new);
	}

	public Estabelecimento create(Estabelecimento estabelecimento) {
		try{
			return estabelecimentoRepository.save(estabelecimento);
		}catch(Exception e){
			throw new ErroAoRegistrarException();
		}
	}

	public Estabelecimento update(String cnpj, EstabelecimentoDTO estabelecimento) {
		Estabelecimento novoEstabelecimento = estabelecimentoRepository.findByCnpj(cnpj).orElseThrow(EstabelecimentoNaoEncontradoException::new);
			novoEstabelecimento.setNome(estabelecimento.getNome());
			novoEstabelecimento.setTelefone(estabelecimento.getTelefone());
			novoEstabelecimento.setEndereco(estabelecimento.getEndereco());
			novoEstabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros());
			novoEstabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos());
			try{
				return estabelecimentoRepository.save(novoEstabelecimento);
			}catch (Exception e){
				throw new ErroAoRegistrarException();
			}
	}

	public String delete(String cnpj) {
		Estabelecimento estabelecimento =  estabelecimentoRepository.findByCnpj(cnpj).orElseThrow(EstabelecimentoNaoEncontradoException::new);
		estabelecimentoRepository.delete(estabelecimento);
		return mensagens.ESTABELECIMENTO_DELETADO_SUCESSO.getDescricao();
	}
}
