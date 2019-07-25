package br.com.estacionamento.estacionamento.service;



import java.util.List;

import br.com.estacionamento.estacionamento.model.Estabelecimento;
import br.com.estacionamento.estacionamento.model.Veiculo;

public class serviceEntradaSaida {
	
	private Estabelecimento estabelecimento;
	private List<Veiculo> veiculos;

	public int totalVagas(int vagasCarro, int vagasMoto) {

		return vagasCarro + vagasMoto;

	}

	public int entrada(Estabelecimento estabelecimento, Veiculo veiculo) {

		if (veiculo.getTipo() == "carro" && estabelecimento.getQtVagasCarros() > 0) {
			estabelecimento.setVeiculos(veiculo);
			estabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros() - 1);
				this.veiculos.add(veiculo);
		} else if (veiculo.getTipo() == "moto" && estabelecimento.getQtVagasMotos() > 0) {
			estabelecimento.setVeiculos(veiculo);
			estabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos() - 1);
				this.veiculos.remove(veiculo);
		}

		return totalVagas(estabelecimento.getQtVagasCarros(), estabelecimento.getQtVagasMotos());
	}
	
	public int saida(Estabelecimento estabelecimento, Veiculo veiculo) {
			
			
			if(veiculo.getTipo() == "carro") {
				estabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros() + 1);
			}else {
				estabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos() + 1);
			}

		return totalVagas(estabelecimento.getQtVagasCarros(), estabelecimento.getQtVagasMotos());
	}

}
