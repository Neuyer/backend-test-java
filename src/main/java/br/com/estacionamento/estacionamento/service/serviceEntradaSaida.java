package br.com.estacionamento.estacionamento.service;



import java.util.List;

import org.springframework.web.bind.annotation.RestController;


import br.com.estacionamento.estacionamento.model.Estabelecimento;
import br.com.estacionamento.estacionamento.model.Veiculo;

@RestController
public class ServiceEntradaSaida {
	
	private Estabelecimento estabelecimento;
	private List<Veiculo> veiculos;

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

	public int totalVagas(int vagasCarro, int vagasMoto) {
		return vagasCarro + vagasMoto;
	}

	public int entrada(Estabelecimento estabelecimento, List<Veiculo> veiculo) {

		if (((Veiculo) veiculo).getTipo() == "carro" && estabelecimento.getQtVagasCarros() > 0) {
			estabelecimento.setVeiculo(veiculo);
			estabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros() - 1);
		} else if (((Veiculo) veiculo).getTipo() == "moto" && estabelecimento.getQtVagasMotos() > 0) {
			estabelecimento.setVeiculo(veiculo);
			estabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos() - 1);
		}

		return totalVagas(estabelecimento.getQtVagasCarros(), estabelecimento.getQtVagasMotos());
	}
	
	public int saida(Estabelecimento estabelecimento, Veiculo veiculo) {
			if(veiculo.getTipo() == "carro") {
				estabelecimento.getVeiculos().remove(veiculo);
				estabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros() + 1);
			}else {
				estabelecimento.getVeiculos().remove(veiculo);
				estabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos() + 1);
			}

		return totalVagas(estabelecimento.getQtVagasCarros(), estabelecimento.getQtVagasMotos());
	}

}
