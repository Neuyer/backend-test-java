package br.com.estacionamento.domain.entity.estabelecimento;

import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;

public class EstabelecimentoCadastroDto {

    private String nome;
    private String cnpj;
    private String telefone;
    private Integer qtVagasCarros;
    private Integer qtVagasMotos;
    private String cep;
    private String rua;
    private String estado;
    private String cidade;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Integer getQtVagasCarros() { return qtVagasCarros; }

    public void setQtVagasCarros(Integer qtVagasCarros) { this.qtVagasCarros = qtVagasCarros; }

    public Integer getQtVagasMotos() { return qtVagasMotos; }

    public void setQtVagasMotos(Integer qtVagasMotos) { this.qtVagasMotos = qtVagasMotos; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }
}
