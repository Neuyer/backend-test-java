package br.com.estacionamento.application;

import br.com.estacionamento.domain.entity.veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public interface VeiculoService {
    List<Veiculo> findAll();
    Veiculo create(Veiculo veiculo);
    Veiculo findByPlaca(String placa);
    Veiculo update(Veiculo veiculo);
    Optional<Veiculo> findById(long id);
    void delete(String placa);
}
