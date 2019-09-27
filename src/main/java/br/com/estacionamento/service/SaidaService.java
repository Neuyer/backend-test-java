package br.com.estacionamento.service;

import br.com.estacionamento.exceptions.EstabelecimentoNaoEncontradoException;
import br.com.estacionamento.exceptions.VagasEsgotadasException;
import br.com.estacionamento.exceptions.VeiculoNaoEncontradoException;
import br.com.estacionamento.model.EntradaSaida;
import br.com.estacionamento.model.Estabelecimento;
import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.EntradaSaidaRepository;
import br.com.estacionamento.repository.EstabelecimentoRepository;
import br.com.estacionamento.repository.VeiculoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @Service
    public class SaidaService {
        private static final String TIPO_CARRO = "carro";
        private static final String SUCESSO = "sucesso!";
        private Logger log = LoggerFactory.getLogger(this.getClass());
        @Autowired
        private EstabelecimentoRepository estabelecimentos;
        @Autowired
        private VeiculoRepository veiculos;
        @Autowired
        private EntradaSaidaRepository entradaSaidaRepository;


        public void checaVagasCarro(Estabelecimento estabelecimento)throws Exception{
            if(estabelecimento.getQtVagasCarros()>0){
                estabelecimento.setQtVagasCarros(estabelecimento.getQtVagasCarros()-1);
            }else{
                throw new VagasEsgotadasException();
            }
        }

        public void checaVagasMoto(Estabelecimento estabelecimento)throws Exception{
            if(estabelecimento.getQtVagasMotos()>0){
                estabelecimento.setQtVagasMotos(estabelecimento.getQtVagasMotos()-1);
            }else{
                throw new VagasEsgotadasException();
            }
        }

        public void checaTipoVaga(Veiculo veiculo, Estabelecimento estabelecimento)throws Exception{
            if(veiculo.getTipo().equals(TIPO_CARRO)){
                checaVagasCarro(estabelecimento);
            }else{
                checaVagasMoto(estabelecimento);
            }
        }

        public void insereVeiculo(String cnpj, String placa ) throws Exception{
            System.out.println("q merda");
            try{

                estabelecimentos.findByCnpj(cnpj).orElseThrow(EstabelecimentoNaoEncontradoException::new);
                veiculos.findByPlaca(placa).orElseThrow(VeiculoNaoEncontradoException::new);
                estabelecimentos.findByCnpj(cnpj).ifPresent(c->{
                    veiculos.findByPlaca(placa).ifPresent(v->{
                        try {
                            checaTipoVaga(v,c);
                            EntradaSaida entradaSaida = new EntradaSaida(c,v);
                            entradaSaidaRepository.save(entradaSaida);
                            log.info(SUCESSO);
                        } catch (Exception e) {
                            e.getMessage();
                            e.printStackTrace();
                        }
                    });
                });
            }catch (Exception erro){
                log.info(erro.getMessage());
            }
        }
}
