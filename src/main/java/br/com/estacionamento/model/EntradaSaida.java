package br.com.estacionamento.model;

import br.com.estacionamento.enums.Estacionado;
import br.com.estacionamento.enums.TipoEvento;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class EntradaSaida implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Estabelecimento estabelecimento;
	@OneToOne
	private Veiculo veiculo;
	private LocalDateTime data;
	private TipoEvento tipoEvento;
	private Estacionado estacionado;

	public EntradaSaida(){

	}
	
	public EntradaSaida(Estabelecimento estabelecimento, Veiculo veiculo, LocalDateTime data, TipoEvento tipo, Estacionado status) {
		this.estabelecimento = estabelecimento;
		this.veiculo = veiculo;
		this.data = data;
		this.tipoEvento = tipo;
		this.estacionado = status;
	}
    public EntradaSaida(Estabelecimento estabelecimento, Veiculo veiculo, LocalDateTime data, TipoEvento tipo) {
        this.estabelecimento = estabelecimento;
        this.veiculo = veiculo;
        this.data = data;
        this.tipoEvento = tipo;
    }

    public EntradaSaida(EntradaSaida entradaSaida, LocalDateTime data, TipoEvento tipo){
		this.veiculo = entradaSaida.getVeiculo();
		this.estabelecimento = entradaSaida.getEstabelecimento();
		this.data = data;
		this.tipoEvento= tipo;
	}

	public Long getId() {
		return id;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public Estacionado getEstacionado() {
		return estacionado;
	}
}
