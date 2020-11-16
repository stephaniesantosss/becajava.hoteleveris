package br.hoteleveris.app.response;

public class QuartoResponse extends BaseResponse{
	
	private int noQuarto;
	private String andar;
	private String situacao;
	
	
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

}
