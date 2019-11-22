package br.com.estacionamento.domain.entity.estabelecimento;


import br.com.estacionamento.domain.entity.Endereco;
import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Estabelecimento {

	@NotEmpty
	private String nome;
	@Id
	@GeneratedValue()
	private long id;
	private String cnpj;
	@OneToOne(mappedBy="estabelecimento")
	private RegistroEvento registroEvento;
	@NotEmpty
	@Pattern(regexp = "\\d{11}")
	private String telefone;
	@NotNull
	private Integer qtVagasCarros = 0;
	@NotNull
	private Integer qtVagasMotos = 0;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	public Estabelecimento() {
		
	}

	public Estabelecimento(String cnpj) {
		cnpj = cnpj;
	}
	
	public Estabelecimento(String nome, String cnpj, String telefone, int qtVagasCarros, int qtVagasMotos) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.qtVagasCarros = qtVagasCarros;
		this.qtVagasMotos = qtVagasMotos;
	}

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

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
