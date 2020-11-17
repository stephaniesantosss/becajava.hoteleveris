package br.hoteleveris.app.request;

import java.util.List;

public class QuartoRequest {
	
	private int noQuarto;
	private String andar;
	private String situacao;
	private Long idTipoQuarto;
	
	private List<ComodidadeRequest> Comodidade;
	
	public int getNoQuarto() {
		return noQuarto;
	}
	public void setNoQuarto(int noQuarto) {
		this.noQuarto = noQuarto;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public List<ComodidadeRequest> getComodidade() {
		return Comodidade;
	}
	public void setComodidade(List<ComodidadeRequest> comodidade) {
		Comodidade = comodidade;
	}
	public Long getIdTipoQuarto() {
		return idTipoQuarto;
	}
	public void setIdTipoQuarto(Long idTipoQuarto) {
		this.idTipoQuarto = idTipoQuarto;
	}
	
	
}
