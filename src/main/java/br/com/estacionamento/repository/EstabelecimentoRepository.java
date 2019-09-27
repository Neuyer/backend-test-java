package br.com.estacionamento.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.model.*;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{
    Optional<Estabelecimento> findByCnpj(String cnpj);
}
