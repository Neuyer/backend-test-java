package br.com.estacionamento.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.model.EntradaSaida;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long>  {

}
