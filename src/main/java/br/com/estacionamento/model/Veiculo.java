package br.com.estacionamento.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Veiculo {

	@NotEmpty
	private String marca;
	@NotEmpty
	private String modelo;
	@NotEmpty
	private String cor;
	@Id
	private String placa;
	@NotEmpty
	private String tipo;
	@OneToOne(mappedBy="veiculo")
	private EntradaSaida entradaSaida;
	
	public Veiculo() {
		super();
	}
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

