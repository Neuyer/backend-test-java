package br.com.estacionamento.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.model.*;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
     Optional<Veiculo> findByPlaca(String placa);
}
