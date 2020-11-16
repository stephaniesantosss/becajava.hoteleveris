package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.service.inter.IClienteService;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public BaseResponse inserir(ClienteRequest request) {
		Cliente cliente = new Cliente();

		if (request.getCpf() == "" || request.getCpf() == null)
			return new BaseResponse(400, "O CPF precisa ser preenchido");

		if (request.getHash() == "" || request.getHash() == null)
			return new BaseResponse(400, "O hash precisa ser preenchido");

		if (request.getNome() == "" || request.getNome() == null)
			return new BaseResponse(400, "O nome do cliente precisa ser preenchido");

		cliente.setCpf(request.getCpf());
		cliente.setHash(request.getHash());
		cliente.setNome(request.getNome());

		repository.save(cliente);
		return new BaseResponse(201, "Cliente inserido com sucesso");
	}

	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		ClienteResponse response = new ClienteResponse();

		if (cliente == null || cliente.isEmpty()) {
			response.message = "Cliente não encontrado";
			response.statusCode = 404;
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());		

		response.message = "Cliente obtido com sucesso";
		response.statusCode = 200;
		return response;
	
	}

}
