package br.com.estacionamento.domain.entity.estabelecimento;


import br.com.estacionamento.domain.entity.Endereco;
import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Estabelecimento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String nome;
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
	public Estabelecimento() {
		
	}

	public Estabelecimento(EstabelecimentoCadastroDto estabelecimentoCadastroDto) {
		nome = estabelecimentoCadastroDto.getNome();
		cnpj = estabelecimentoCadastroDto.getCnpj();
		telefone = estabelecimentoCadastroDto.getTelefone();
		qtVagasCarros = estabelecimentoCadastroDto.getQtVagasCarros();
		qtVagasMotos = estabelecimentoCadastroDto.getQtVagasMotos();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
