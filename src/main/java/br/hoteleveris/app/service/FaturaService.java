package br.hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.request.TransferenciaRequest;

@Service
public class FaturaService {

	@Autowired
	private OcupacaoRepository ocupacaoRepository;

	public BaseResponse transferencia() {

		BaseResponse response = new BaseResponse();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8081/operacao/transferencia";
		String hashContaHotel = "123";

		List<Ocupacao> lista = ocupacaoRepository.findBySituacao("N");


		// VARREDURA DA LISTA DE OCUPAÇÕES COM VALOR DE SITUAÇÃO "N"
		for (Ocupacao ocupacao : lista) {
			double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getQtdeDiarias();

			TransferenciaRequest transferenciaRequest = new TransferenciaRequest();
			transferenciaRequest.setHashDestino(hashContaHotel);
			transferenciaRequest.setHashOrigem(ocupacao.getCliente().getHash());
			transferenciaRequest.setValor(valor);

			// REQUISIÇÃO
			restTemplate.postForObject(url, transferenciaRequest, BaseResponse.class);

			ocupacao.setSituacao("P");
			ocupacaoRepository.save(ocupacao);

		}
		response.statusCode = 200;
		response.message = "Transferencia completa";

		return response;

	}

}
