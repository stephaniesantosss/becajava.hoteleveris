package br.hoteleveris.app.response;

import java.util.Date;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Quarto;

public class OcupacaoResponse extends BaseResponse{
	
	private String data;
	private int qtdeDiarias;
	private String situacao;
	private Cliente clienteId;
	private Quarto quartoId;
	
	public int getQtdeDiarias() {
		return qtdeDiarias;
	}
	public void setQtdeDiarias(int qtdeDiarias) {
		this.qtdeDiarias = qtdeDiarias;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Cliente getClienteId() {
		return clienteId;
	}
	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	public Quarto getQuartoId() {
		return quartoId;
	}
	public void setQuartoId(Quarto quartoId) {
		this.quartoId = quartoId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

}
