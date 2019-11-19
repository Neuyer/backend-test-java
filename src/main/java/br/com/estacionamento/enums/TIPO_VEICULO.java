package br.com.estacionamento.enums;

public enum TIPO_VEICULO {
    CARRO("carro"),
    MOTO("moto");

    private String descricao;

    TIPO_VEICULO(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
