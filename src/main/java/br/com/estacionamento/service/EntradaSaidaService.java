package br.com.estacionamento.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estacionamento.model.EntradaSaida;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import br.com.estacionamento.repository.VeiculoRepository;

@Service
public class EntradaSaidaService {
	@Autowired
	private EstabelecimentoRepository estabelecimentos;
	@Autowired
	private VeiculoRepository veiculos;

	public void insereVeiculo(Long eId,long vId) {
		estabelecimentos.findById(eId).ifPresent(c->{
			EntradaSaida entradaSaida = new EntradaSaida(c);
			veiculos.findById(vId).ifPresent(v->{
				entradaSaida.setVeiculo(v);
			});
		});
	}
}
