package br.com.estacionamento.application;

import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;

import java.util.List;

public interface EstabelecimentoService {
    List<Estabelecimento> findAll();
    Estabelecimento findByCnpj(String cnpj);
    Estabelecimento create(Estabelecimento estabelecimento);
    Estabelecimento update(Estabelecimento estabelecimento);
    void delete(String cnpj);
}
