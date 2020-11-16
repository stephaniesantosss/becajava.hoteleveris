package br.hoteleveris.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class QuartoComodidade  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "quartoId")
	private Quarto quarto;	
	
	@ManyToOne
	@JoinColumn(name = "comodidadeId")
	private Comodidade comodidade;

	public QuartoComodidade(Quarto quarto, Comodidade comodidade) {
		this.quarto = quarto;
		this.comodidade = comodidade;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Comodidade getComodidade() {
		return comodidade;
	}

	public void setComodidade(Comodidade comodidade) {
		this.comodidade = comodidade;
	}	
	

}
