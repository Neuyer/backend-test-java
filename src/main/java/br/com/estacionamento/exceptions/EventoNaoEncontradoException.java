package br.com.estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNaoEncontradoException extends Exception {
    public EventoNaoEncontradoException(){super("Evento não encontrado!");};
}
