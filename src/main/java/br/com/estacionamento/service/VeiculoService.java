package br.com.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.VeiculoRepository;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	VeiculoService(VeiculoRepository repo){
		this.veiculoRepository = repo;
	}
	
	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();
	}
	
	public ResponseEntity<Veiculo> buscaPorId(@PathVariable long id) {
		return veiculoRepository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
		public ResponseEntity<Veiculo> buscaPorPlaca(@PathVariable String placa){
			return veiculoRepository.findByPlaca(placa)
					.map(record -> ResponseEntity.ok().body(record))
					.orElse(ResponseEntity.notFound().build());
		}
	public Veiculo create(@RequestBody Veiculo veiculo){
	   return veiculoRepository.save(veiculo);
	}
	
	public ResponseEntity<Veiculo> update(@PathVariable("id") long id,
	                                      @RequestBody Veiculo veiculo) {
	   return veiculoRepository.findById(id)
	           .map(nveiculo -> {
	        	   nveiculo.setMarca(veiculo.getMarca());
	        	   nveiculo.setModelo(veiculo.getModelo());
	        	   nveiculo.setCor(veiculo.getCor());
	        	   nveiculo.setPlaca(veiculo.getPlaca());
	        	   nveiculo.setTipo(veiculo.getTipo());
	               Veiculo updated = veiculoRepository.save(nveiculo);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<?> delete(@PathVariable long id) {
	   return veiculoRepository.findById(id)
	           .map(record -> {
	               veiculoRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
