package br.com.estacionamento.service.implementation;

import br.com.estacionamento.enums.TIPO_VEICULO;
import br.com.estacionamento.exceptions.VagasEsgotadasException;
import br.com.estacionamento.model.EntradaSaida;
import br.com.estacionamento.model.EntradaSaidaDTO;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.EntradaSaidaRepository;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import br.com.estacionamento.repository.VeiculoRepository;
import br.com.estacionamento.service.EntradaSaidaService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EntradaSaidaServiceImp implements EntradaSaidaService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EstabelecimentoRepository estabelecimentos;
    @Autowired
    private VeiculoRepository veiculoRepository;
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
        if (veiculo.getTipo().equals(TIPO_VEICULO.CARRO.getDescricao())) {
            checaVagasCarro(estabelecimento);
        } else {
            checaVagasMoto(estabelecimento);
        }
    }

    @Transactional
    public void registraEvento(String cnpj, String placa) {
    }

    @Override
    public List<EntradaSaida> findRegistrosEventosByDate(Estabelecimento estabelecimento, LocalDateTime Date) {
        return null;
    }
}
