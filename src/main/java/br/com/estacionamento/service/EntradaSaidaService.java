package br.com.estacionamento.service;

import br.com.estacionamento.enums.Mensagens;
import br.com.estacionamento.enums.TipoEvento;
import br.com.estacionamento.enums.TiposVeiculos;
import br.com.estacionamento.exceptions.*;
import br.com.estacionamento.model.EntradaSaida;
import br.com.estacionamento.model.EntradaSaidaDTO;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.EntradaSaidaRepository;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import br.com.estacionamento.repository.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class EntradaSaidaService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private TiposVeiculos tiposVeiculos;
    private TipoEvento tipoEvento;
    private Mensagens mensagens;
    @Autowired
    private EstabelecimentoRepository estabelecimentos;
    @Autowired
    private VeiculoRepository veiculos;
    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    public Boolean checaEntrada(Long id){
        Optional entrada = entradaSaidaRepository.findById(id);
        if(entrada.isPresent()){
            return true;
        }
        return false;
    }

    private EntradaSaidaDTO toDto(EntradaSaida entradaSaida){
        ModelMapper modelMapper = new ModelMapper();
        EntradaSaidaDTO entradaSaidaDto = modelMapper.map(entradaSaida,EntradaSaidaDTO.class);
        return entradaSaidaDto;
    }

    private void checaVagasCarro(Estabelecimento estabelecimento) throws Exception {
        if (estabelecimento.getQtVagasCarros() > 0) {
            estabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros() - 1);
        } else {
            throw new VagasEsgotadasException();
        }
    }

    private void checaVagasMoto(Estabelecimento estabelecimento) throws Exception {
        if (estabelecimento.getQtVagasMotos() > 0) {
            estabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos() - 1);
        } else {
            throw new VagasEsgotadasException();
        }
    }

    private void checaTipoVaga(Veiculo veiculo, Estabelecimento estabelecimento) throws Exception {
        if (veiculo.getTipo().equals(tiposVeiculos.CARRO.getDescricao())) {
            checaVagasCarro(estabelecimento);
        } else {
            checaVagasMoto(estabelecimento);
        }
    }

    public boolean checaEventoAtivo(String placa) {
        List<EntradaSaida> eventos = entradaSaidaRepository.findAllByVeiculoPlaca(placa);
        return eventos.stream().anyMatch(c -> c.isAtivo());
    }
    public EntradaSaida registraEntrada(EntradaSaidaDTO entrada) throws Exception {
        LocalDateTime data = LocalDateTime.now();
        String tipo = tipoEvento.ENTRADA.getDescriçao();
        if(checaEventoAtivo(entrada.getPlacaVeiculo())){
           throw new EventoJaRegistradoException();
        }
        try {
            Estabelecimento estabelecimento = estabelecimentos.findByCnpj(entrada.getCnpjEstabelecimento()).orElseThrow(EstabelecimentoNaoEncontradoException::new);
            Veiculo veiculo = veiculos.findByPlaca(entrada.getPlacaVeiculo()).orElseThrow(VeiculoNaoEncontradoException::new);
            try {
                checaTipoVaga(veiculo, estabelecimento);
                EntradaSaida entradaSaida = new EntradaSaida(estabelecimento, veiculo, data, tipo,true);
                log.info(mensagens.EVENTO_REGISTRADO_SUCESSO.getDescricao());
               return entradaSaidaRepository.save(entradaSaida);

            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
                throw new ErroAoRegistrarException();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new ErroAoRegistrarException();
        }
    }

    public ResponseEntity<EntradaSaidaDTO> registraSaida(Long id) throws Exception{
        LocalDateTime data = LocalDateTime.now();
        String tipo = tipoEvento.SAIDA.getDescriçao();
        try {
            EntradaSaida eventoEntrada = entradaSaidaRepository.findById(id).orElseThrow(EventoNaoEncontradoException::new);
            EntradaSaida eventoSaida = new EntradaSaida(eventoEntrada, data, tipo);
            entradaSaidaRepository.save(eventoSaida);
            return  new ResponseEntity<EntradaSaidaDTO>(toDto(eventoSaida),HttpStatus.CREATED);
        }catch (EventoNaoEncontradoException e){
            log.info(e.getMessage());
            return  new ResponseEntity<EntradaSaidaDTO>(HttpStatus.NOT_FOUND);
        }
    }
}
