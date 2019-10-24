package br.com.estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErroAoRegistrarException extends RuntimeException {
    public ErroAoRegistrarException(){
        super("Erro ao registrar, verifique os campos preenchidos...");
    }
}
