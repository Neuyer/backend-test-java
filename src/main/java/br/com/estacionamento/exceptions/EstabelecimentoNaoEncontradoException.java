package br.com.estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstabelecimentoNaoEncontradoException extends RuntimeException{
    public EstabelecimentoNaoEncontradoException(){
        super("Estabelecimento não Encontrado!!!");
    }
}
