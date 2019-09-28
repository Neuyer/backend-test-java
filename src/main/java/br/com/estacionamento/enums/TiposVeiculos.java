package br.com.estacionamento.enums;

public enum TiposVeiculos {
    CARRO("carro"),
    MOTO("moto");

    private String descricao;

    TiposVeiculos(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
