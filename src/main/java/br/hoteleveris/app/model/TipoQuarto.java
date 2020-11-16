package br.hoteleveris.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoQuarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private double valor;
	
	public TipoQuarto() {
		
	}
	
	public TipoQuarto(Long id) {
		super();
		this.id = id;
	}	
	
	public TipoQuarto(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
