package br.com.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EntradaSaida {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Estabelecimento estabelecimento;
	@OneToOne
	private Veiculo veiculo;

	public EntradaSaida(){

	}
	
	public EntradaSaida( Estabelecimento estabelecimento, Veiculo veiculo) {
		this.estabelecimento = estabelecimento;
		this.veiculo = veiculo;
	}
	
}
