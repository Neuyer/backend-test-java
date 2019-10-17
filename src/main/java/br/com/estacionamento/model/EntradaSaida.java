package br.com.estacionamento.model;

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
	private String tipoEvento;
	private boolean status;

	public EntradaSaida(){

	}
	
	public EntradaSaida( Estabelecimento estabelecimento, Veiculo veiculo, LocalDateTime data, String tipo, boolean status) {
		this.estabelecimento = estabelecimento;
		this.veiculo = veiculo;
		this.data = data;
		this.tipoEvento = tipo;
		this.status = status;
	}
    public EntradaSaida( Estabelecimento estabelecimento, Veiculo veiculo, LocalDateTime data, String tipo) {
        this.estabelecimento = estabelecimento;
        this.veiculo = veiculo;
        this.data = data;
        this.tipoEvento = tipo;
    }

    public Long getId() {
        return id;
    }
    public Veiculo getVeiculo() {
		return veiculo;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

}
