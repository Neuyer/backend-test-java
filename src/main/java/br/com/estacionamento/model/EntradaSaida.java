package br.com.estacionamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EntradaSaida {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@OneToOne
	private Estabelecimento estabelecimento;
	@OneToOne
	private Veiculo veiculo;
	
	public EntradaSaida(Long id, Estabelecimento estabelecimento, Veiculo veiculo) {
		super();
		this.id = id;
		this.estabelecimento = estabelecimento;
		this.veiculo = veiculo;
	}
	public EntradaSaida(Estabelecimento estabelecimento) {
		this.estabelecimento =estabelecimento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
}
