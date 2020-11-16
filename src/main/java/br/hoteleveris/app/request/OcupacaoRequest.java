package br.hoteleveris.app.request;

import java.util.Date;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Quarto;

public class OcupacaoRequest {
	
	private Date data;
	private int qtdeDiarias;
	private String situacao;
	private Long clienteId;
	private Long quartoId;
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
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getQuartoId() {
		return quartoId;
	}
	public void setQuartoId(Long quartoId) {
		this.quartoId = quartoId;
	}
	

	
	
}
