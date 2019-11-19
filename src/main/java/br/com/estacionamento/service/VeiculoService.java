package br.com.estacionamento.service;

import br.com.estacionamento.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    List<Veiculo> findAll();
    Veiculo create(Veiculo veiculo);
    Veiculo findByPlaca(String placa);
    Veiculo update(Veiculo veiculo);
    void delete(String placa);
}
