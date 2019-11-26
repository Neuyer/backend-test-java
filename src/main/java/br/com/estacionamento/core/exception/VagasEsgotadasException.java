package br.com.estacionamento.core.exception;

public class VagasEsgotadasException extends RuntimeException{
    public VagasEsgotadasException(){
        super("VAGAS ESGOTADAS!!!");
    }
}
