package br.com.estacionamento.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class EntradaSaida {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@OneToOne
	private Estabelecimento estabelecimento;
	@OneToMany(mappedBy="entradaSaida")
	private List<Veiculo> veiculos;
	
	public EntradaSaida(Long id, Estabelecimento estabelecimento, List<Veiculo> veiculos) {
		super();
		this.id = id;
		this.estabelecimento = estabelecimento;
		this.veiculos = veiculos;
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
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public void setVeiculos(Veiculo v) {
		this.veiculos.add(v);
	}
	
}
