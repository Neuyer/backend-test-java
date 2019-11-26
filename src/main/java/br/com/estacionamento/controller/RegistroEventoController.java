package br.com.estacionamento.controller;

import br.com.estacionamento.domain.entity.registroEvento.RegistroEvento;
import br.com.estacionamento.domain.entity.registroEvento.RegistroEventoDto;
import br.com.estacionamento.application.RegistroEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/registroEvento")
public class RegistroEventoController {

	@Autowired
	private RegistroEventoService registroEventoService;

	@PostMapping
	public ResponseEntity<?> registrarEvento(@RequestParam String cnpj, @RequestParam String placa)  {
		registroEventoService.registraEvento(new RegistroEventoDto(cnpj, placa));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{date}")
	public ResponseEntity<List<RegistroEvento>> findRegistrosEventosEstabelecimentoByDate(@PathVariable LocalDateTime date, long estabelecimentoId) {
		return new ResponseEntity<>(registroEventoService.findRegistrosEventosEstabelecimentoByDate(estabelecimentoId, date), HttpStatus.OK);
	}
}
