package br.hoteleveris.app.response;

import java.util.Date;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Quarto;

public class OcupacaoResponse extends BaseResponse{
	
	private Date data;
	private int qtdeDiarias;
	private String situacao;
	private Cliente clienteId;
	private Quarto quartoId;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
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

}
