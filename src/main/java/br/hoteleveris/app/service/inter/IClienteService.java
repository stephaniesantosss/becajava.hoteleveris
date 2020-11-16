package br.hoteleveris.app.service.inter;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;

public interface IClienteService {
	 BaseResponse inserir(ClienteRequest request);
}
