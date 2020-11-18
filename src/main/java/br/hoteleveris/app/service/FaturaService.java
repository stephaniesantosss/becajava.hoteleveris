package br.hoteleveris.app.service;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.response.BaseResponse;

@Service
public interface FaturaService {
	
	BaseResponse transferencia();

}
