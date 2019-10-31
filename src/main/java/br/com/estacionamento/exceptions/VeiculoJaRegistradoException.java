package br.com.estacionamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VeiculoJaRegistradoException extends RuntimeException {
    public VeiculoJaRegistradoException(){
        super("Veiculo já registrado!!!");
    }
}
