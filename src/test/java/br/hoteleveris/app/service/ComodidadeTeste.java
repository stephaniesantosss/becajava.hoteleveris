package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.imp.ComodidadeServiceImp;

@SpringBootTest
public class ComodidadeTeste {
	@Autowired
	ComodidadeServiceImp service;

	@Test
	public void criarComodidade() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("NomeComodidadeTeste");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
	}
	
	@Test
	public void criarComodidadeNomeVazio() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void obterPorId() {
		BaseResponse response = service.obter(1L);
		Assertions.assertEquals(200,response.getStatusCode());
	}


}
