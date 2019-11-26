package br.com.estacionamento.domain.repository;
import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{
    Optional<Estabelecimento> findByCnpj(String cnpj);
}
