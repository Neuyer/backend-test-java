package br.com.estacionamento.service.implementation;

import java.util.List;
import java.util.Optional;
import br.com.estacionamento.exceptions.VeiculoNaoEncontradoException;
import br.com.estacionamento.service.VeiculoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.VeiculoRepository;
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
        Veiculo veiculoUpdate = veiculoRepository.findByPlaca(veiculo.getPlaca()).orElseThrow(VeiculoNaoEncontradoException::new);
        veiculoUpdate.setMarca(veiculo.getMarca());
        veiculoUpdate.setModelo(veiculo.getModelo());
        veiculoUpdate.setCor(veiculo.getCor());
        veiculoUpdate.setPlaca(veiculo.getPlaca());
        veiculoUpdate.setTipo(veiculo.getTipo());
        return veiculoUpdate;
    }

    @Transactional
    public void delete(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
        veiculoRepository.delete(veiculo);
    }
}
