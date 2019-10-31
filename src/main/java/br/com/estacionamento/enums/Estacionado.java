package br.com.estacionamento.enums;

public enum Estacionado {
    ESTACIONADO("Estacionado"),
    NAO_ESTACIONADO("Não Estacionado");

    private String descricao;
   Estacionado(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
