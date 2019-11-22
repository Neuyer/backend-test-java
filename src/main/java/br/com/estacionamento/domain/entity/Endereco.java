package br.com.estacionamento.domain.entity;

import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id @GeneratedValue
    private long id;
    private String cep;
    private String rua;
    private String estado;
    private String cidade;
    @OneToOne(mappedBy = "endereco")
    private Estabelecimento estabelecimento;
}
