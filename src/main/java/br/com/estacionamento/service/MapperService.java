package br.com.estacionamento.service;

import br.com.estacionamento.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MapperService extends ModelMapper {

    public VeiculoDTO toVeiculoDTO(Veiculo veiculo){
        return map(veiculo, VeiculoDTO.class);
    }

    public Veiculo dtoToVeiculo(VeiculoDTO veiculoDTO){
        return map(veiculoDTO, Veiculo.class);
    }

    public EstabelecimentoDTO toEstabelecimentoDTO(Estabelecimento estabelecimento){
        return map(estabelecimento, EstabelecimentoDTO.class);
    }

    public Estabelecimento dtoToEstabelecimento(EstabelecimentoDTO estabelecimentoDTO){
        return map(estabelecimentoDTO, Estabelecimento.class);
    }

    public EntradaSaidaDTO toEntradaSaidaDTO(EntradaSaida entradaSaida){
        return map(entradaSaida, EntradaSaidaDTO.class);
    }

    public EntradaSaida dtoToEntradaSaida(EntradaSaidaDTO entradaSaidaDTO){
        return map(entradaSaidaDTO, EntradaSaida.class);
    }
}
