package br.com.estacionamento.domain.repository;
import br.com.estacionamento.domain.entity.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
     Optional<Veiculo> findByPlaca(String placa);
     Optional<Veiculo> deleteByPlaca(String placa);
}
