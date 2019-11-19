package br.com.estacionamento.service;

import br.com.estacionamento.model.EntradaSaida;
import br.com.estacionamento.model.Estabelecimento;

import java.time.LocalDateTime;
import java.util.List;

public interface EntradaSaidaService {
    void registraEvento(String placaVeiculo, String cnpjEstabelecimento);
    List<EntradaSaida> findRegistrosEventosByDate(Estabelecimento estabelecimento, LocalDateTime Date);
}
