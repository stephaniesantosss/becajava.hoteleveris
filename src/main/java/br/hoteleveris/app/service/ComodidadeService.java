package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.response.ComodidadeResponse;


@Service
public class ComodidadeService {

	@Autowired
	private ComodidadeRepository repository;
	
	public BaseResponse inserir(ComodidadeRequest request) { 
		Comodidade comodidade = new Comodidade(null);
		
		if (request.getNome() == "")
			return new BaseResponse(400,"O nome da comodidade precisa ser preenchido");
	
		comodidade.setNome(request.getNome());
	
		
		
		repository.save(comodidade);		
		return new BaseResponse(201,"Comodidade inserida com sucesso");
	}
	
	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = repository.findById(id);
		ComodidadeResponse response = new ComodidadeResponse();

		if (comodidade == null) {
			response.message = "Comodidade não encontrado";
			response.statusCode = 404;
			return response;
		}

		response.setNome(comodidade.get().getNome());
		

		response.message = "Comodidade obtida com sucesso";
		response.statusCode = 200;
		return response;
	}

}


