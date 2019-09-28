package br.com.estacionamento.enums;

public enum Mensagens {
    EVENTO_REGISTRADO_SUCESSO("Evento registrado com sucesso!");
    private String descricao;
    Mensagens(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
