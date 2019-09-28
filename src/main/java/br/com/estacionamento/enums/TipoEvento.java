package br.com.estacionamento.enums;

public enum TipoEvento {
    ENTRADA("entrada"),
    SAIDA("saida");

    private String descricao;

    TipoEvento(String descricao){
        this.descricao = descricao;
    }

    public String getDescriçao() {
        return descricao;
    }
}
