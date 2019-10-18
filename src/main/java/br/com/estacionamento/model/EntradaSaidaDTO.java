package br.com.estacionamento.model;

public class EntradaSaidaDTO {
    private Long id;
    private String cnpjEstabelecimento;
    private String placaVeiculo;
    public  EntradaSaidaDTO(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCnpjEstabelecimento(String cnpjEstabelecimento) {
        this.cnpjEstabelecimento = cnpjEstabelecimento;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public Long getId() {
        return id;
    }

    public String getCnpjEstabelecimento() {
        return cnpjEstabelecimento;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

}
