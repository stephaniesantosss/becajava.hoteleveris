package br.hoteleveris.app.service;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;
import br.hoteleveris.app.service.imp.OcupacaoService;

@SpringBootTest
public class OcupacaoTeste {

	@Autowired
	private OcupacaoService service;
	String dataString = "dd/MM/yyyy";
	SimpleDateFormat formato = new SimpleDateFormat(dataString);
	
	@Test
	public void criar() {
		
		OcupacaoRequest request = new OcupacaoRequest();
		
		request.setClienteId(2L);
		request.setQuartoId(17L);
		request.setData("11/11/2011");
		request.setQtdeDiarias(3);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
	}
	
	@Test
	public void criarSemCliente() {
		
		OcupacaoRequest request = new OcupacaoRequest();
		
		
		request.setQuartoId(17L);
		request.setData("10/10/2020");
		request.setQtdeDiarias(1);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		
	}
	
	@Test
	public void situacaoPagamentoVazio() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("10/10/2020");
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacao("");

	BaseResponse response = service.inserir(request);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	
	@Test
	public void criarSemQUarto() {
		
		OcupacaoRequest request = new OcupacaoRequest();
		
		request.setClienteId(2L);
		
		request.setData("10/10/2020");
		request.setQtdeDiarias(2);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O ID do quarto precisa ser preenchido", response.getMessage());
	}
	
	@Test
	public void semData() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("10/10/2020");
	request.setQtdeDiarias(1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacao("");

	BaseResponse response = service.inserir(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void dataNull() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData(null);
	request.setQtdeDiarias(1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacao("");

	BaseResponse response = service.inserir(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void DiariaZero() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("10/10/2020");
	request.setQtdeDiarias(0);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacao("P");

	BaseResponse response = service.inserir(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void DiariaMenorQueZero() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("10/10/2020");
	request.setQtdeDiarias(-1);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	request.setSituacao("P");

	BaseResponse response = service.inserir(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void pegarLista() {
	ListOcupacaoResponse obj = new ListOcupacaoResponse();
	obj.setOcupacoes(obj.getOcupacoes());
	
	BaseResponse response = service.listar();
	Assertions.assertEquals(200,response.getStatusCode());

	
	}
	
	@Test
	public void inserirClienteNull () {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("10/10/2020");
		request.setQtdeDiarias(1);
		request.setQuartoId(1L);
		request.setClienteId(null);
		request.setSituacao("P");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
		Assertions.assertEquals("O ID do cliente precisa ser preenchido", response.message);
		
	}
	
	@Test
	public void QuartoIdNull() {
	OcupacaoRequest request = new OcupacaoRequest();
	request.setData("10/10/2020");
	request.setQtdeDiarias(1);
	request.setQuartoId(null);
	request.setClienteId(0L);
	request.setSituacao("P");

	BaseResponse response = service.inserir(request);
	Assertions.assertEquals(400,response.getStatusCode());
	Assertions.assertEquals("O ID do quarto precisa ser preenchido", response.message);
	
	}
	
	@Test
	public void DataNull () {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData(null);
		request.setQtdeDiarias(1);
		request.setQuartoId(1L);
		request.setClienteId(2L);
		request.setSituacao("P");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
		Assertions.assertEquals("A data precisa ser preenchida", response.message);
		
	}
	
	@Test
	public void SituacaoNull () {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("10/10/2020");
		request.setQtdeDiarias(1);
		request.setQuartoId(1L);
		request.setClienteId(2L);
		request.setSituacao(null);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
		}
	
	@Test
	public void SituacaoVazio () {
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("10/10/2020");
		request.setQtdeDiarias(1);
		request.setQuartoId(1L);
		request.setClienteId(2L);
		request.setSituacao("");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400,response.getStatusCode());
		
		
	}
	
}
