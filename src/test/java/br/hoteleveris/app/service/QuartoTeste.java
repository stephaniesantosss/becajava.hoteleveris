package br.hoteleveris.app.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class QuartoTeste {

	@Autowired
	private QuartoService service;
	
	@Test
    public void criar() {
        QuartoRequest request =  new QuartoRequest();
        request.setAndar("20");

        List<ComodidadeRequest> teste = new ArrayList<ComodidadeRequest>();
        ComodidadeRequest comodidade = new ComodidadeRequest();
        
        teste.add(comodidade);

        request.setNoQuarto(110);
        request.setSituacao("Ativo");

        BaseResponse response = service.inserir(request);
        Assertions.assertEquals(201, response.getStatusCode());

    }

	@Test
	public void obterPorIdzero() {
		BaseResponse response = service.obter(0L);
		Assertions.assertEquals(400, response.getStatusCode());
	}

}
