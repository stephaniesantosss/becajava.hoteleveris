package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.service.FaturaService;

@RestController
@RequestMapping("/fatura")
public class FaturaController {
	
	@Autowired
	private FaturaService _service;
	
	@PostMapping
	public ResponseEntity inserir() {
		try {
			_service.inserir();
			return ResponseEntity.status(200).body("Faturas inseridas com sucesso");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Erro genérico");
		}		
	}

}

