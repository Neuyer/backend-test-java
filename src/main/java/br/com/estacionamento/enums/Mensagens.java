package br.com.estacionamento.enums;

public enum Mensagens {
    EVENTO_REGISTRADO_SUCESSO("Evento registrado com sucesso!"),
    ESTABELECIMENTO_REGISTRADO_SUCESSO("Estabelecimento registrado com sucesso!"),
    ESTABELECIMENTO_DELETADO_SUCESSO("Estabelecimento deletado com sucesso!"),
    VEICULO_REGISTRADO_SUCESSO("Veiculo registrado com sucesso!"),
    VEICULO_ENCONTRADO_COM_SUCESSO("Veiculo encontrado com sucesso!"),
    VEICULO_DELETADO_COM_SUCESSO("Veiculo deletado com sucesso!");
    private String descricao;
    Mensagens(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
