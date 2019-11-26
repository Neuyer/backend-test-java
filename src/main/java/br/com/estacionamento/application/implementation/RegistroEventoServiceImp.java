package br.com.estacionamento.application.implementation;

import br.com.estacionamento.domain.entity.veiculo.TIPO_VEICULO;
import br.com.estacionamento.core.exception.VagasEsgotadasException;
import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;
import br.com.estacionamento.domain.entity.registroEvento.RegistroEventoDto;
import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;
import br.com.estacionamento.domain.entity.veiculo.Veiculo;
import br.com.estacionamento.domain.repository.RegistroEventoRepository;
import br.com.estacionamento.domain.repository.EstabelecimentoRepository;
import br.com.estacionamento.domain.repository.VeiculoRepository;
import br.com.estacionamento.application.RegistroEventoService;
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
public class RegistroEventoServiceImp implements RegistroEventoService {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EstabelecimentoRepository estabelecimentos;
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private RegistroEventoRepository registroEventoRepository;

    public Boolean checaEntrada(Long id){
        Optional entrada = registroEventoRepository.findById(id);
        if(entrada.isPresent()){
            return true;
        }
        return false;
    }

    private RegistroEventoDto toDto(RegistroEvento registroEvento){
        ModelMapper modelMapper = new ModelMapper();
        RegistroEventoDto registroEventoDto = modelMapper.map(registroEvento, RegistroEventoDto.class);
        return registroEventoDto;
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
    @Override
    public void registraEvento(RegistroEventoDto registroEvento) {

    }

    @Override
    public List<RegistroEvento> findRegistrosEventosEstabelecimentoByDate(long estabelecimentoId, LocalDateTime Date) {
        return null;
    }
}
