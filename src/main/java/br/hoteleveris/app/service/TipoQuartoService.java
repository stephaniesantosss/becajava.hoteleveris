package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

@Service
public class TipoQuartoService {

	@Autowired
	private TipoQuartoRepository repository;
	
	public BaseResponse inserir(TipoQuartoRequest request) { 
		TipoQuarto tipoQuarto = new TipoQuarto();
		
		if (request.getDescricao() == "")
			return new BaseResponse(400,"A descrição precisa ser preenchida");
		
		if (request.getValor() <= 0) 
			return new BaseResponse(400,"O valor do tipo quarto precisa ser preenchido");
		
		
		tipoQuarto.setDescricao(request.getDescricao());
		tipoQuarto.setValor(request.getValor());
		
		repository.save(tipoQuarto);		
		return new BaseResponse(201,"Tipo Quarto inserido com sucesso");
	}
	
	public TipoQuartoResponse obter(Long id) {
		Optional<TipoQuarto> tquarto = repository.findById(id);
		TipoQuartoResponse response = new TipoQuartoResponse();

		if (tquarto == null) {
			response.message = "Tipo do quarto não encontrado";
			response.statusCode = 404;
			return response;
		}

		response.setDescricao(tquarto.get().getDescricao());
		response.setValor(tquarto.get().getValor());
		

		response.message = "Tipo do quarto obtido com sucesso";
		response.statusCode = 200;
		return response;
	}
	
	public TipoQuartoList listar() {
		List<TipoQuarto> lista = repository.findAll();

		TipoQuartoList response = new TipoQuartoList();
		response.setTipoQuartos(lista);
		response.statusCode = 200;
		response.message = "Tipos de quarto obtidos com sucesso.";

		return response;
	}
}

