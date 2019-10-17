package br.com.estacionamento.model;

public class EntradaSaidaDTO {
    private Long id;
    private String cnpjEstabelecimento;
    private String placaveiculo;
    public  EntradaSaidaDTO(){

    }
    public EntradaSaidaDTO(EntradaSaida entrada){

    }

    public EntradaSaidaDTO novoEntradaSaidaDTO(EntradaSaida entrada){
        return new EntradaSaidaDTO(entrada);
    }
}
