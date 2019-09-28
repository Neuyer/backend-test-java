package br.com.estacionamento.model;




import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Estabelecimento {

	@NotEmpty
	private String nome;
	@Id
	@Pattern(regexp = "\\d{14}")
	private String cnpj;
	@OneToOne(mappedBy="estabelecimento")
	private EntradaSaida entradaSaida;
	@NotEmpty
	private String endereco;
	@NotEmpty
	@Pattern(regexp = "\\d{11}")
	private String telefone;
	@NotNull
	private Integer qtVagasCarros = 0;
	@NotNull
	private Integer qtVagasMotos = 0;
	
	public Estabelecimento() {
		
	}
	
	public Estabelecimento(long id, String nome, String cnpj, String telefone, int qtVagasCarros, int qtVagasMotos) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.qtVagasCarros = qtVagasCarros;
		this.qtVagasMotos = qtVagasMotos;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQtVagasCarros() {
		return qtVagasCarros;
	}

	public void setQtVagasCarros(int qtVagasCarros) {
		this.qtVagasCarros = qtVagasCarros;
	}

	public int getQtVagasMotos() {
		return qtVagasMotos;
	}

	public void setQtVagasMotos(int qtVagasMotos) {
		this.qtVagasMotos = qtVagasMotos;
	}

}
