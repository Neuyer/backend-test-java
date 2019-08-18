package br.com.estacionamento.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Estabelecimento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String cnpj;
	@NotEmpty
	private String endereco;
	@NotEmpty
	private String telefone;
	@NotEmpty
	private int qtVagasCarros = 0;
	@NotEmpty
	private int qtVagasMotos = 0;
	
	public Estabelecimento() {
		
	}
	
	public Estabelecimento(long id, String nome, String cnpj, String telefone, int qtVagasCarros, int qtVagasMotos) {
		super();
		this.id = id;
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

	public long getId() {
		return id;
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
