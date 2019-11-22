package br.com.estacionamento.application.implementation;

import java.util.List;
import java.util.Optional;
import br.com.estacionamento.core.exception.VeiculoException;
import br.com.estacionamento.application.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.estacionamento.domain.entity.veiculo.Veiculo;
import br.com.estacionamento.domain.repository.VeiculoRepository;
import javax.transaction.Transactional;

@Service
public class VeiculoServiceImp implements VeiculoService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    public Veiculo findByPlaca(String placa) {
       Optional<Veiculo> veiculoOpt =  veiculoRepository.findByPlaca(placa);
        return veiculoOpt.orElseGet(Veiculo::new);
    }

    @Transactional
    public Veiculo create(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public Veiculo update(Veiculo veiculo) {
        Veiculo veiculoUpdate = veiculoRepository.findByPlaca(veiculo.getPlaca()).orElseThrow(VeiculoException::new);
        veiculoUpdate.setMarca(veiculo.getMarca());
        veiculoUpdate.setModelo(veiculo.getModelo());
        veiculoUpdate.setCor(veiculo.getCor());
        veiculoUpdate.setPlaca(veiculo.getPlaca());
        veiculoUpdate.setTipo(veiculo.getTipo());
        return veiculoUpdate;
    }

    @Transactional
    public void delete(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoException::new);
        veiculoRepository.delete(veiculo);
    }
}
