package br.hoteleveris.app.response;

public class TipoQuartoResponse extends BaseResponse{
	
	private String descricao;
	private double valor;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
