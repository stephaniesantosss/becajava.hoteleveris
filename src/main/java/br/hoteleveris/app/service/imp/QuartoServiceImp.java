package br.hoteleveris.app.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.QuartoComodidade;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoComodidadeRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;

@Service
public class QuartoServiceImp {

	@Autowired
	private QuartoRepository repository;

	@Autowired
	private QuartoComodidadeRepository _repository;

	public BaseResponse inserir(QuartoRequest request) {
		Quarto quarto = new Quarto();

		if (request.getAndar() == "")
			return new BaseResponse(400, "O andar precisa ser preenchido");

		if (request.getNoQuarto() <= 0)
			return new BaseResponse(400, "O número do quarto precisa ser maior que 0");
	
		if (request.getSituacao() == "")
			return new BaseResponse(400, "A situação do quarto precisa ser preenchido");
		
		if (request.getSituacao() == null)
			return new BaseResponse(400, "A situação do quarto precisa ser preenchido!");
		

		quarto.setAndar(request.getAndar());
		quarto.setNoQuarto(request.getNoQuarto());
		quarto.setSituacao(request.getSituacao());

		TipoQuarto o = new TipoQuarto();

		o.setId(request.getIdTipoQuarto());
		quarto.setTipoQuarto(o);

		repository.save(quarto);
		

		Optional<Quarto> getquarto = repository.findByNoQuarto(request.getNoQuarto());

		Long quartoId = getquarto.get().getId();

		for (ComodidadeRequest item : request.getComodidade()) {

			Quarto quart = new Quarto();
			quart.setId(quartoId);

			Comodidade c = new Comodidade();
			c.setId(item.getId());

			QuartoComodidade quartoComodidade = new QuartoComodidade();

			quartoComodidade.setComodidade(c);
			quartoComodidade.setQuarto(quart);

			_repository.save(quartoComodidade);
		}

		return new BaseResponse(201, "Quarto inserido com sucesso");

	}

	public QuartoResponse obter(Long id) {
		Optional<Quarto> quarto = repository.findById(id);
		QuartoResponse response = new QuartoResponse();

		if (quarto.equals(null) || quarto.isEmpty())
		{
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

	public ListQuartoResponse listarTipoQuarto(Long id) {

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

		if (request.getSituacao() == "") {
			response.statusCode = 400;
			response.message = "Campo vazio";
			return response;
		} 

		quarto.get().setSituacao(request.getSituacao());

		repository.save(quarto.get());

		response.message = "Situação do quarto atualizado com sucesso";
		response.statusCode = 200;

		return response;

	}

}
