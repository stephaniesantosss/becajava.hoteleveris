package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.imp.FaturaService;

@SpringBootTest
public class FaturaTeste {
	
	@Autowired
	private FaturaService service;
	
	@Test
	public void Transferencia() {
		BaseResponse response = service.transferencia();
		
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Transferencia completa", response.getMessage());
		
	}
	
}
