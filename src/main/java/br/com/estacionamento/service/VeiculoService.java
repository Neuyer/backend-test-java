package br.com.estacionamento.service;

import java.util.List;
import java.util.Map;

import br.com.estacionamento.enums.Mensagens;
import br.com.estacionamento.exceptions.ErroAoRegistrarException;
import br.com.estacionamento.exceptions.VeiculoNaoEncontradoException;
import br.com.estacionamento.model.VeiculoDTO;
import org.modelmapper.ModelMapper;
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

    public Veiculo buscaPorPlaca(String placa) throws Exception {
        return veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
    }

    public Veiculo create(Veiculo veiculo) {
        try{
            return veiculoRepository.save(veiculo);
        }
        catch (Exception e){
            throw new ErroAoRegistrarException();
        }
    }

    public Veiculo update(String placa, VeiculoDTO veiculo) throws Exception {
         Veiculo v = veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
         log.info(mensagem.VEICULO_ENCONTRADO_COM_SUCESSO.getDescricao());
         v.setMarca(veiculo.getMarca());
         v.setModelo(veiculo.getModelo());
         v.setCor(veiculo.getCor());
         v.setTipo(veiculo.getTipo());
         log.info(mensagem.VEICULO_REGISTRADO_SUCESSO.getDescricao());

        try{
            return veiculoRepository.save(v);
        }
        catch(Exception e){
          throw new ErroAoRegistrarException();
       }
    }

    public String delete(String placa) {
        Veiculo v = veiculoRepository.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
        log.info(mensagem.VEICULO_ENCONTRADO_COM_SUCESSO.getDescricao());
        veiculoRepository.delete(v);
        log.info(mensagem.VEICULO_DELETADO_COM_SUCESSO.getDescricao());
        return mensagem.VEICULO_DELETADO_COM_SUCESSO.getDescricao();
    }
}
