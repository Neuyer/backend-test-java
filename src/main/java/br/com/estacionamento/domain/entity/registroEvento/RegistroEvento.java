package br.com.estacionamento.domain.entity.registroEvento;

import br.com.estacionamento.domain.entity.estabelecimento.Estabelecimento;
import br.com.estacionamento.domain.entity.veiculo.Veiculo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroEvento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Estabelecimento estabelecimento;
	@OneToOne
	private Veiculo veiculo;
	private LocalDateTime data;
	private String tipoEvento;
	private boolean ativo;
	private EVENTO evento;

	public RegistroEvento(){

	}

	public Long getId() {
		return id;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean status){
		this.ativo = status;
	}

}
