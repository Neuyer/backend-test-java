package br.com.estacionamento.application;

import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;
import br.com.estacionamento.domain.entity.estabelecimento.EstabelecimentoCadastroDto;

import java.util.List;
import java.util.Optional;

public interface EstabelecimentoService {
    List<Estabelecimento> findAll();
    Estabelecimento findByCnpj(String cnpj);
    Estabelecimento create(EstabelecimentoCadastroDto estabelecimentoCadastroDto);
    Estabelecimento update(Estabelecimento estabelecimento);
    Optional<Estabelecimento> findById(long id);
    void delete(String cnpj);
}
