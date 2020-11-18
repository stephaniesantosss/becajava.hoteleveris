package br.hoteleveris.app.service;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;

@Service
public interface ClienteService {
	
	BaseResponse inserir(ClienteRequest request);
	ClienteResponse obter(Long id);

}
