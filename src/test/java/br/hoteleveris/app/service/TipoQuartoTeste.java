package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;
import br.hoteleveris.app.service.imp.TipoQuartoServiceImp;

@SpringBootTest
public class TipoQuartoTeste {

	@Autowired
	private TipoQuartoServiceImp service;

	@Test
	public void criarTipoQuarto() {

		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("Economico");
		request.setValor(200.00);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.getStatusCode());
	}

	@Test
	public void criarTipoQuartoSemDescricao() {

		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("");
		request.setValor(2000.00);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void criarTipoQuartoSemValor() {

		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("teste");
		request.setValor(0.0);

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void obter() {
		Long id = 1L;

		TipoQuartoResponse response = service.obter(id);

		Assertions.assertEquals(200, response.getStatusCode());

	}

	@Test
	public void obterIdInvalido() {
		Long id = -1L;

		TipoQuartoResponse response = service.obter(id);

		Assertions.assertEquals(400, response.getStatusCode());
		

	}

	@Test
	public void obterIdInexistente() {
		Long id = 100000L;

		TipoQuartoResponse response = service.obter(id);

		Assertions.assertEquals(400, response.getStatusCode());

	}

	@Test
	public void pegarLista() {
		TipoQuartoList obj = new TipoQuartoList();
		obj.setTipoQuartos(obj.getTipoQuartos());

		BaseResponse response = service.listar();
		Assertions.assertEquals(200, response.getStatusCode());

	}

}