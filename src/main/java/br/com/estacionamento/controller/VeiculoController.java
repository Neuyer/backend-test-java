package br.com.estacionamento.controller;


import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.model.VeiculoDTO;
import br.com.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@GetMapping
	public List<Veiculo> findAll() {
		return veiculoService.findAll();
	}

	@GetMapping(value="/{placa}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	Veiculo buscaPorPlaca(@PathVariable String placa) throws Exception {return veiculoService.buscaPorPlaca(placa);}

	@PostMapping
	@ResponseBody
	public Veiculo create(@RequestBody Veiculo veiculo)throws Exception{
	   return veiculoService.create(veiculo);
	}
	
	@PutMapping(value="/{placa}")
	@ResponseBody
	public Veiculo update(@PathVariable("placa") String placa,
	                                      @RequestBody VeiculoDTO veiculo) throws Exception {
	   return veiculoService.update(placa, veiculo);
	}


	@DeleteMapping(value ={"/{placa}"})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public String delete(@PathVariable("placa") String placa) {
	   return veiculoService.delete(placa);
	}
}
