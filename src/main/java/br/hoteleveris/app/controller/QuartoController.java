package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.service.QuartoService;

@RestController
@RequestMapping("/quartos")
public class QuartoController {
	
	@Autowired
	private QuartoService _service;
	
	@PostMapping
	public ResponseEntity inserir(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = _service.inserir(request);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro genérico");
		}		
	}
	
	@GetMapping(path = "/{id}")
    public ResponseEntity obter(@PathVariable Long id) {		
		try {
			QuartoResponse response = _service.obter(id);
			return ResponseEntity.status(response.getStatusCode()).body(response);	
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro genérico");
		}   	
    }

}
