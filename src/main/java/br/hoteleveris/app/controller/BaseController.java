package br.hoteleveris.app.controller;

import br.hoteleveris.app.response.BaseResponse;

public class BaseController {
	
	public BaseResponse error = new BaseResponse();
	
	public BaseController() {
		error.statusCode = 500;
		error.message = "Ocorreu um erro inesperados.";
	}

}