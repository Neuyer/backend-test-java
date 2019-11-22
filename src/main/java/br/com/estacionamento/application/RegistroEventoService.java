package br.com.estacionamento.application;

import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;
import br.com.estacionamento.domain.entity.registroEvento.RegistroEventoDto;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroEventoService {
    void registraEvento(RegistroEventoDto registroEvento);
    List<RegistroEvento> findRegistrosEventosEstabelecimentoByDate(long estabelecimentoId, LocalDateTime Date);
}
