package br.com.estacionamento.service;

import java.util.List;

import br.com.estacionamento.enums.Mensagens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.VeiculoRepository;
import org.springframework.web.bind.annotation.RequestParam;

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

    public ResponseEntity<Veiculo> buscaPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public Veiculo create(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public ResponseEntity<Veiculo> update(String placa,
                                          @RequestBody Veiculo veiculo) {
        return veiculoRepository.findByPlaca(placa)
                .map(nveiculo -> {
                    nveiculo.setMarca(veiculo.getMarca());
                    nveiculo.setModelo(veiculo.getModelo());
                    nveiculo.setCor(veiculo.getCor());
                    nveiculo.setPlaca(veiculo.getPlaca());
                    nveiculo.setTipo(veiculo.getTipo());
                    Veiculo updated = veiculoRepository.save(nveiculo);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<?> delete(String placa) {
        return veiculoRepository.findByPlaca(placa)
                .map(record -> {
                    veiculoRepository.deleteByPlaca(placa);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
