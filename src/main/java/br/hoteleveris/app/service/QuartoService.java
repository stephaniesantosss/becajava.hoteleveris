package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.service.inter.IClienteService;


@Service
public class QuartoService {

	@Autowired
	private QuartoRepository repository;
	
	public BaseResponse inserir(QuartoRequest request) { 
		Quarto quarto = new Quarto();
		
		if (request.getAndar() == "")
			return new BaseResponse(400,"O andar precisa ser preenchido");
		
		if (request.getNoQuarto() <= 0 ) 
			return new BaseResponse(400,"O número do quarto precisa ser preenchido");
		
		if (request.getSituacao() == "") 
			return new BaseResponse(400,"A situação do quarto precisa ser preenchido");
		
		
		quarto.setAndar(request.getAndar());
		quarto.setNoQuarto(request.getNoQuarto());
		quarto.setSituacao(request.getSituacao());
		
		repository.save(quarto);		
		return new BaseResponse(201,"Quarto inserido com sucesso");
	}
	
	public QuartoResponse obter(Long id) {
		Optional<Quarto> quarto = repository.findById(id);
		QuartoResponse response = new QuartoResponse();

		if (quarto == null) {
			response.message = "Quarto não encontrado";
			response.statusCode = 404;
			return response;
		}

		response.setAndar(quarto.get().getAndar());
		response.setNoQuarto(quarto.get().getNoQuarto());
		response.setSituacao(quarto.get().getSituacao());

		response.message = "Quarto obtido com sucesso";
		response.statusCode = 200;
		return response;
	}
	
	public ListQuartoResponse listar(Long id) {

		ListQuartoResponse response = new ListQuartoResponse();
		List<Quarto> lista = repository.findBuscarQuartos(id);

		response.setQuartos(lista);
		response.statusCode = 200;
		response.message = "Quartos obtidos com sucesso.";

		return response;
	}

	
	public BaseResponse atualizar(Long id, SituacaoQuartoRequest request) {
		BaseResponse response = new BaseResponse();

		Optional<Quarto> quarto = repository.findById(id);
 
		if (request.getSituacao().isEmpty()) {
			response.statusCode = 400;
			response.message = "Situação do quarto não pode ser vazia";
			return response;
		} else if (quarto.isEmpty() || id <= 0) {
			response.statusCode = 400;
			response.message = "Id do quarto não pode ser zero ou vazio";
			return response;
		}

		quarto.get().setSituacao(request.getSituacao());

		repository.save(quarto.get());

		response.message = "Situação do quarto atualizado com sucesso";
		response.statusCode = 200;

		return response;

	}


}
