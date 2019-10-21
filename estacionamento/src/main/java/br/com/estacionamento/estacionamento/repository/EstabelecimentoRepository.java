package br.com.estacionamento.estacionamento.repository;
import br.com.estacionamento.estacionamento.model.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{

	void save(Optional<Estabelecimento> estab);



}
