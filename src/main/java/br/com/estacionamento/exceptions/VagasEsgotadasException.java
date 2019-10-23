package br.com.estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VagasEsgotadasException extends RuntimeException{
    public VagasEsgotadasException(){
        super("VAGAS ESGOTADAS!!!");
    }
}
