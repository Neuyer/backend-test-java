package br.com.estacionamento.exceptions;

public class EstabelecimentoNaoEncontradoException extends RuntimeException{
    public EstabelecimentoNaoEncontradoException(){
        super("Estabelecimento não Encontrado!!!");
    }
}
