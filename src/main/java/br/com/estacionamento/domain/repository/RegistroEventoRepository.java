package br.com.estacionamento.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;

import java.util.List;

public interface RegistroEventoRepository extends JpaRepository<RegistroEvento, Long>  {
    List<RegistroEvento> findAllByVeiculoPlaca(String placa);
}
