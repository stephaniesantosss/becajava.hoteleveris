package br.hoteleveris.app.service;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;

@Service
public interface QuartoService {
	
	BaseResponse inserir(QuartoRequest request);
	QuartoResponse obter(Long id);
	ListQuartoResponse listarTipoQuarto(Long id);
	BaseResponse atualizar(Long id, SituacaoQuartoRequest request);

}
