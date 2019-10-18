package br.com.estacionamento.repository;
import br.com.estacionamento.model.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.model.EntradaSaida;

import java.util.List;
import java.util.Optional;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long>  {
    List<EntradaSaida> findAllByVeiculoPlaca(String placa);
}
