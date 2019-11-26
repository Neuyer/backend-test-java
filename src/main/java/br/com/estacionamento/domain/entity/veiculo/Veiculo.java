package br.com.estacionamento.domain.entity.veiculo;

import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Veiculo {

	@Id @GeneratedValue
	private long id;
	@NotEmpty
	private String marca;
	@NotEmpty
	private String modelo;
	@NotEmpty
	private String cor;
	@Pattern(regexp = "^(([a-zA-Z]{3})?([0-9]{4}))$")
	private String placa;
	@NotEmpty
	private String tipo;
	@OneToOne(mappedBy="veiculo")
	private RegistroEvento registroEvento;
	
	public Veiculo() {
	}

	public Veiculo(String placa) {
		placa = placa;
	}
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

