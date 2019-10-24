package br.com.estacionamento.model;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EstabelecimentoDTO {
    @NotEmpty
    private String nome;
    @NotEmpty
    private String endereco;
    @NotEmpty
    @Pattern(regexp = "\\d{11}")
    private String telefone;
    @NotNull
    private Integer qtVagasCarros = 0;
    @NotNull
    private Integer qtVagasMotos = 0;

    public EstabelecimentoDTO( String nome,  String endereco, String telefone, Integer qtVagasCarros, Integer qtVagasMotos) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.qtVagasCarros = qtVagasCarros;
        this.qtVagasMotos = qtVagasMotos;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public Integer getQtVagasCarros() {
        return qtVagasCarros;
    }

    public Integer getQtVagasMotos() {
        return qtVagasMotos;
    }
}
