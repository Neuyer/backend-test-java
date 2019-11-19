package br.com.estacionamento.exceptions;

public class EventoJaRegistradoException extends Exception{
    public EventoJaRegistradoException(){
        super("Evento já registrado!");
    }
}
