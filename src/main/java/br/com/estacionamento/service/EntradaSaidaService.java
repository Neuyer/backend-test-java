package br.com.estacionamento.service;

import br.com.estacionamento.enums.Mensagens;
import br.com.estacionamento.enums.TipoEvento;
import br.com.estacionamento.enums.TiposVeiculos;
import br.com.estacionamento.exceptions.EstabelecimentoNaoEncontradoException;
import br.com.estacionamento.exceptions.EventoNaoEncontradoException;
import br.com.estacionamento.exceptions.VagasEsgotadasException;
import br.com.estacionamento.exceptions.VeiculoNaoEncontradoException;
import br.com.estacionamento.model.EntradaSaida;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.EntradaSaidaRepository;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import br.com.estacionamento.repository.VeiculoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


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


    public void checaVagasCarro(Estabelecimento estabelecimento) throws Exception {
        if (estabelecimento.getQtVagasCarros() > 0) {
            estabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros() - 1);
        } else {
            throw new VagasEsgotadasException();
        }
    }

    public void checaVagasMoto(Estabelecimento estabelecimento) throws Exception {
        if (estabelecimento.getQtVagasMotos() > 0) {
            estabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos() - 1);
        } else {
            throw new VagasEsgotadasException();
        }
    }

    public void checaTipoVaga(Veiculo veiculo, Estabelecimento estabelecimento) throws Exception {
        if (veiculo.getTipo().equals(tiposVeiculos.CARRO.getDescricao())) {
            checaVagasCarro(estabelecimento);
        } else {
            checaVagasMoto(estabelecimento);
        }
    }

    public void registraEntrada(String cnpj, String placa) throws Exception {
        LocalDateTime data = LocalDateTime.now();
        String tipo = tipoEvento.ENTRADA.getDescriçao();
        try {
            Estabelecimento estabelecimento = estabelecimentos.findByCnpj(cnpj).orElseThrow(EstabelecimentoNaoEncontradoException::new);
            Veiculo veiculo = veiculos.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
            try {
                checaTipoVaga(veiculo, estabelecimento);
                EntradaSaida entradaSaida = new EntradaSaida(estabelecimento, veiculo, data, tipo);
                entradaSaidaRepository.save(entradaSaida);
                log.info(mensagens.EVENTO_REGISTRADO_SUCESSO.getDescricao());
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        } catch (Exception erro) {
            log.info(erro.getMessage());
        }
    }

    public void registraSaida(String placa) throws Exception{
        LocalDateTime data = LocalDateTime.now();
        String tipo = tipoEvento.SAIDA.getDescriçao();
        try {
            EntradaSaida EventoEntrada = entradaSaidaRepository.findByVeiculoPlaca(placa).orElseThrow(EventoNaoEncontradoException::new);
            EntradaSaida EventoSaida = new EntradaSaida(EventoEntrada.getEstabelecimento(), EventoEntrada.getVeiculo(), data, tipo);
            entradaSaidaRepository.save(EventoSaida);
        }catch (EventoNaoEncontradoException e){
            log.info(e.getMessage());
        }
    }
}
