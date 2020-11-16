package br.hoteleveris.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private int noQuarto;
	
	private String andar;
	private String situacao;
	
	@ManyToOne
	@JoinColumn(name = "tipoQuartoId")
	private TipoQuarto tipoQuarto;
	
	public Quarto() {
	}

	public Quarto(Long id) {
		super();
		this.id = id;
	}

	public Quarto(int noQuarto, String andar, String situacao, TipoQuarto tipoQuarto) {
		super();
		this.noQuarto = noQuarto;
		this.andar = andar;
		this.situacao = situacao;
		this.tipoQuarto = tipoQuarto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	

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
	
	

}
