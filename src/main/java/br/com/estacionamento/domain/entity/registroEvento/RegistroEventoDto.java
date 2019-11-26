package br.com.estacionamento.domain.entity.registroEvento;

public class RegistroEventoDto {
    private Long id;
    private String cnpjEstabelecimento;
    private String placaVeiculo;

    public RegistroEventoDto(){

    }

    public RegistroEventoDto(String cnpj, String placa) {
        cnpjEstabelecimento = cnpj;
        placaVeiculo = placa;
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
