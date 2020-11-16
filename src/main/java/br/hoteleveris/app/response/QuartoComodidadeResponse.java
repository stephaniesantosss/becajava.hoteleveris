package br.hoteleveris.app.response;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.Quarto;

public class QuartoComodidadeResponse extends BaseResponse{
	
	private Quarto quartoId;
	private Comodidade comodidadeId;
	
	public Quarto getQuartoId() {
		return quartoId;
	}
	public void setQuartoId(Quarto quartoId) {
		this.quartoId = quartoId;
	}
	public Comodidade getComodidadeId() {
		return comodidadeId;
	}
	public void setComodidadeId(Comodidade comodidadeId) {
		this.comodidadeId = comodidadeId;
	}

}
