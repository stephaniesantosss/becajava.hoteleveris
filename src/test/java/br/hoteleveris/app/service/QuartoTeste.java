package br.hoteleveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;

@SpringBootTest
public class QuartoTeste {

	@Autowired
	private QuartoService service;
	
	public int pegarNumeroRandomico(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }
	
	@Test
    public void criarQuarto() {

        QuartoRequest request = new QuartoRequest();
        request.setAndar("9");
        request.setIdTipoQuarto(1l);

        request.setSituacao("A");
        int nq = this.pegarNumeroRandomico(1, 1000);
        request.setNoQuarto(nq);

        List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
        ComodidadeRequest obj = new ComodidadeRequest();
        obj.setId(1L);
        comodidades.add(obj);

        request.setComodidade(comodidades);

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(201, response.statusCode);

        Assertions.assertEquals("Quarto Comodidade inserido com sucesso", response.message);

    }
	
	@Test
	public void criarQuartoSituacaoNull() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar("20");
		request.setIdTipoQuarto(1L);
		request.setSituacao(null);
		int nq = this.pegarNumeroRandomico(1, 1000);
		request.setNoQuarto(nq);
		
		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest obj = new ComodidadeRequest();
		obj.setId(1L);
		comodidades.add(obj);
		
		request.setComodidade(comodidades);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarAndarVazio() {
		
		QuartoRequest request = new QuartoRequest();
        request.setAndar("");
        request.setIdTipoQuarto(1l);

        request.setSituacao("A");
        int nq = this.pegarNumeroRandomico(1, 1000);
        request.setNoQuarto(nq);

        List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
        ComodidadeRequest obj = new ComodidadeRequest();
        obj.setId(1L);
        comodidades.add(obj);

        request.setComodidade(comodidades);

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(400, response.statusCode);

        Assertions.assertEquals("O andar precisa ser preenchido", response.message);
	}
	
	@Test
	public void criarQuartoNumeroZero() {

		QuartoRequest request = new QuartoRequest();
		request.setAndar("1");
		request.setIdTipoQuarto(1L);
		request.setSituacao("A");

		request.setNoQuarto(-0);
		
		List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest obj = new ComodidadeRequest();
		obj.setId(1L);
		comodidades.add(obj);
		
		request.setComodidade(comodidades);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarNumQuartoMenorZero() {
		
		QuartoRequest request = new QuartoRequest();
        request.setAndar("30");
        request.setIdTipoQuarto(1l);

        request.setSituacao("A");
        request.setNoQuarto(-0);

        List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
        ComodidadeRequest obj = new ComodidadeRequest();
        obj.setId(1L);
        comodidades.add(obj);

        request.setComodidade(comodidades);

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(400, response.statusCode);

        Assertions.assertEquals("O número do quarto precisa ser maior que 0", response.message);
	}

	
	@Test
	public void criarQuartoSituacaoVazio() {
		
		QuartoRequest request = new QuartoRequest();
        request.setAndar("30");
        request.setIdTipoQuarto(1l);

        request.setSituacao("");
        int nq = this.pegarNumeroRandomico(1, 1000);
        request.setNoQuarto(nq);

        List<ComodidadeRequest> comodidades = new ArrayList<ComodidadeRequest>();
        ComodidadeRequest obj = new ComodidadeRequest();
        obj.setId(1L);
        comodidades.add(obj);

        request.setComodidade(comodidades);

        BaseResponse response = service.inserir(request);

        Assertions.assertEquals(400, response.statusCode);

        Assertions.assertEquals("A situação do quarto precisa ser preenchido", response.message);
	}
	
	@Test
	public void atualizarSituacaoQuartoPorId() {
		SituacaoQuartoRequest sr = new SituacaoQuartoRequest();
		sr.setSituacao("A");
		
		BaseResponse response = service.atualizar(1L, sr);
		Assertions.assertEquals(200, response.getStatusCode());
	}

	
	@Test
	public void obterPorId() {
		Long id = 2L;
        QuartoResponse response = service.obter(id);

        Assertions.assertEquals(200, response.statusCode);
        Assertions.assertEquals("Quarto obtido com sucesso", response.message );

    }
	
	@Test
	public void atualizarSituacaoVazio() {
		SituacaoQuartoRequest situacao = new SituacaoQuartoRequest();
		situacao.setSituacao("");
		
		BaseResponse response = service.atualizar(1L, situacao);
		Assertions.assertEquals(400, response.getStatusCode());
	}	
	
	@Test
	public void obterPorIdzero() {
		BaseResponse response = service.obter(0L);
		Assertions.assertEquals(400, response.getStatusCode());
	}

	@Test
	public void pegarLista() {
	ListQuartoResponse obj = new ListQuartoResponse();
	obj.setQuartos(obj.getQuartos());
	Long id = 2l;
	BaseResponse response = service.listarTipoQuarto(id);
	Assertions.assertEquals(200,response.getStatusCode());

	
	}
	
	@Test
	public void obterPorIdTipoQuarto() {
		BaseResponse response = service.listarTipoQuarto(1L);
		Assertions.assertEquals(200, response.getStatusCode());
	}
}
