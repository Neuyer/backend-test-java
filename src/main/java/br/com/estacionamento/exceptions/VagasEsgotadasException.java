package br.com.estacionamento.exceptions;

public class VagasEsgotadasException extends RuntimeException{
    public VagasEsgotadasException(){
        super("VAGAS ESGOTADAS!!!");
    }
}
