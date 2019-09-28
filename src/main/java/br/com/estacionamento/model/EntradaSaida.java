package br.com.estacionamento.model;

import br.com.estacionamento.enums.TipoEvento;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EntradaSaida {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Estabelecimento estabelecimento;
	@OneToOne
	private Veiculo veiculo;
	private LocalDateTime data;
	private String tipoEvento;

	public EntradaSaida(){

	}
	
	public EntradaSaida( Estabelecimento estabelecimento, Veiculo veiculo, LocalDateTime data, String tipo) {
		this.estabelecimento = estabelecimento;
		this.veiculo = veiculo;
		this.data = data;
		this.tipoEvento = tipo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
}
