package br.com.estacionamento.domain.entity;

import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;
import br.com.estacionamento.domain.entity.estabelecimento.EstabelecimentoCadastroDto;

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


    public Endereco(){

    }

    public  Endereco(EstabelecimentoCadastroDto estabelecimentoCadastroDto) {
        cep = estabelecimentoCadastroDto.getCep();
        rua = estabelecimentoCadastroDto.getRua();
        estado = estabelecimentoCadastroDto.getEstado();
        cidade = estabelecimentoCadastroDto.getCidade();
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public Estabelecimento getEstabelecimento() { return estabelecimento; }

    public void setEstabelecimento(Estabelecimento estabelecimento) { this.estabelecimento = estabelecimento; }
}
