package br.com.estacionamento.service;

import java.util.List;

import br.com.estacionamento.enums.Mensagens;
import br.com.estacionamento.exceptions.VeiculoNaoEncontradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.VeiculoRepository;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Service
public class VeiculoService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private Mensagens mensagem;
    @Autowired
    private VeiculoRepository veiculoRepository;

    VeiculoService(VeiculoRepository repo) {
        this.veiculoRepository = repo;
    }

    public List<Veiculo> findAll() {
        return veiculoRepository.findAll();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Veiculo buscaPorPlaca(String placa) throws Exception {
        return veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
    }

    public Veiculo create(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo update(String placa, Veiculo veiculo) {
         Veiculo v = veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
         v.setMarca(veiculo.getMarca());
         v.setModelo(veiculo.getModelo());
         v.setCor(veiculo.getCor());
         v.setPlaca(veiculo.getPlaca());
         v.setTipo(veiculo.getTipo());
       return veiculoRepository.save(v);
    }

    public String delete(String placa) {
        Veiculo v = veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
        veiculoRepository.delete(v);
        return mensagem.VEICULO_DELETADO_COM_SUCESSO.getDescricao();
    }
}
