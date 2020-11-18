package br.hoteleveris.app.service;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;

@Service
public interface OcupacaoService {
	
	BaseResponse inserir(OcupacaoRequest request);
	ListOcupacaoResponse listar();

}
