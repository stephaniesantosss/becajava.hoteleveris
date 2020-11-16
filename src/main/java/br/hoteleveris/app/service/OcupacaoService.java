package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.OcupacaoResponse;


@Service
public class OcupacaoService {

	@Autowired
	private OcupacaoRepository repository;
	
	public BaseResponse inserir(OcupacaoRequest request) { 
		Ocupacao ocupacao = new Ocupacao();
		
		if (request.getClienteId() == null)
			return new BaseResponse(400,"O ID do cliente precisa ser preenchido");
		
		if (request.getQuartoId() == null) 
			return new BaseResponse(400,"O ID do quarto precisa ser preenchido");
		
		if (request.getQtdeDiarias() <= 0) 
			return new BaseResponse(400,"A quantidade de diarias precisa ser preenchida");
		
		if (request.getData() == null) 
			return new BaseResponse(400,"A data precisa ser preenchida");
		
		if (request.getSituacao() == null) 
			return new BaseResponse(400,"A situação do quarto precisa ser preenchida");
		
		Quarto quarto =  new Quarto(request.getQuartoId());
		
		Cliente cliente = new Cliente (request.getClienteId());
		
		ocupacao.setQuarto(quarto);
		ocupacao.setCliente(cliente);
		ocupacao.setSituacao(request.getSituacao());
		ocupacao.setData(request.getData());
		ocupacao.setQtdeDiarias(request.getQtdeDiarias());
		
		
		repository.save(ocupacao);		
		return new BaseResponse(201,"Ocupação inserida com sucesso");
	}
	
	public ListOcupacaoResponse listar() {

		List<Ocupacao> lista = repository.findAll();

		ListOcupacaoResponse response = new ListOcupacaoResponse();
		response.setOcupacoes(lista);
		response.statusCode = 200;
		response.message = "Ocupações obtidas com sucesso.";

		return response;
	}
}

