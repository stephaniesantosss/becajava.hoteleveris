package br.hoteleveris.app.service;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

@Service
public interface TipoQuartoService {
	
	BaseResponse inserir(TipoQuartoRequest request);
	TipoQuartoResponse obter(Long id);
	TipoQuartoList listar();

}
