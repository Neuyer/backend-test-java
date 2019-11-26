package br.com.estacionamento.controller;


import br.com.estacionamento.domain.entity.MENSAGENS;
import br.com.estacionamento.domain.entity.veiculo.Veiculo;
import br.com.estacionamento.application.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		return new ResponseEntity<>(veiculoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("{îd}")
	public ResponseEntity<Veiculo> findById(@PathVariable long id) {
		Optional<Veiculo> veiculoOpt = veiculoService.findById(id);
		return veiculoOpt.map(veiculo -> new ResponseEntity<>(veiculo, HttpStatus.OK))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/{placa}")
	public ResponseEntity<Veiculo> findByPlaca(@PathVariable String placa) {
		Veiculo veiculo = veiculoService.findByPlaca(placa);
		if(!veiculo.getPlaca().isEmpty())
			return new ResponseEntity<>(veiculo, HttpStatus.OK);

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo){
		return new ResponseEntity<>(veiculoService.create(veiculo), HttpStatus.CREATED);
	}
	
	@PutMapping("/{placa}")
	public ResponseEntity<Veiculo> update(@PathVariable String placa, @RequestBody Veiculo veiculo) {
		veiculo.setPlaca(placa);
	   return new ResponseEntity<>(veiculoService.update(veiculo), HttpStatus.OK);
	}

	@DeleteMapping("/{placa}")
	public ResponseEntity<String> delete(@PathVariable String placa) {
		veiculoService.delete(placa);
		return new ResponseEntity<>(MENSAGENS.VEICULO_DELETADO_COM_SUCESSO.getDescricao(), HttpStatus.OK);
	}
}
