package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.imp.FaturaServiceImp;

@RestController
@RequestMapping("/fatura")
public class FaturaController extends BaseController{
	
	@Autowired
	private FaturaServiceImp _service;
	
	@PostMapping
	public ResponseEntity<BaseResponse> transferencia () {
		try {
			BaseResponse response =_service.transferencia();
			return ResponseEntity.status(response.statusCode).body(response);
			
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}

}
