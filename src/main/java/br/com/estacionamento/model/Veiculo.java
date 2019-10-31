package br.com.estacionamento.model;

import br.com.estacionamento.enums.TiposVeiculos;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@IdClass(VeiculoId.class)
public class Veiculo {
	@Id
	@GeneratedValue
	Long id;
	@Id
	@Pattern(regexp = "^(([a-zA-Z]{3})?([0-9]{4}))$")
	private String placa;

	private TiposVeiculos tipo;
	@NotEmpty
	private String marca;
	@NotEmpty
	private String modelo;
	@NotEmpty
	private String cor;
	@OneToOne(mappedBy="veiculo")
	private EntradaSaida entradaSaida;
	
	public Veiculo() {
		this.id = 0l;
	}

	public Veiculo( String marca, String modelo, String cor, TiposVeiculos tipo) {
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TiposVeiculos getTipo() {
		return tipo;
	}
	public void setTipo(TiposVeiculos tipo){
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Veiculo)) return false;
		Veiculo veiculo = (Veiculo) o;
		return Objects.equals(getId(), veiculo.getId()) &&
				Objects.equals(getMarca(), veiculo.getMarca()) &&
				Objects.equals(getModelo(), veiculo.getModelo()) &&
				Objects.equals(getCor(), veiculo.getCor()) &&
				Objects.equals(getPlaca(), veiculo.getPlaca()) &&
				Objects.equals(getTipo(), veiculo.getTipo()) &&
				Objects.equals(entradaSaida, veiculo.entradaSaida);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getMarca(), getModelo(), getCor(), getPlaca(), getTipo(), entradaSaida);
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}

