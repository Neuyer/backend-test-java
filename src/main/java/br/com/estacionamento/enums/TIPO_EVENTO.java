package br.com.estacionamento.enums;

public enum TIPO_EVENTO {
    ENTRADA("entrada"),
    SAIDA("saida");

    private String descricao;

    TIPO_EVENTO(String descricao){
        this.descricao = descricao;
    }

    public String getDescriçao() {
        return descricao;
    }
}
