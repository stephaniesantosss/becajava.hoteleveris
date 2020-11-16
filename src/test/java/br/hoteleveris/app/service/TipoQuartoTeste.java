package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class TipoQuartoTeste {
	
	@Autowired
	private TipoQuartoService service;
	
	@Test
	public void criarTipoQuarto() {
		
		TipoQuartoRequest request = new TipoQuartoRequest();
		request.setDescricao("Teste");
		request.setValor(2000.00);

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
	public void obterPorId() {
		BaseResponse response = service.obter(1L);
		Assertions.assertEquals(200,response.getStatusCode());
	}
	
	@Test
	public void obterPorIdzero() {
		BaseResponse response = service.obter(0L);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void obterPorIdNaoExistente() {
		BaseResponse response = service.obter(999999L);
		Assertions.assertEquals(400,response.getStatusCode());
	}

}