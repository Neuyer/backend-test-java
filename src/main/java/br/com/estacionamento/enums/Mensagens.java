package br.com.estacionamento.enums;

public enum Mensagens {
    EVENTO_REGISTRADO_SUCESSO("Evento registrado com sucesso!"),
    ESTABELECIMENTO_REGISTRADO_SUCESSO("Estabelecimento registrado com sucesso!"),
    VEICULO_REGISTRADO_SUCESSO("Veiculo registrado com sucesso!");
    private String descricao;
    Mensagens(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
