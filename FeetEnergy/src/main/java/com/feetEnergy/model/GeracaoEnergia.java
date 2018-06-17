package com.feetEnergy.model;

import java.sql.Date;

public class GeracaoEnergia {
	
	private Integer idGeracao;
	private Date data;
	private double gerado;
	private int tempo;
	private int porcentagem;
	public Integer getIdGeracao() {
		return idGeracao;
	}
	public void setIdGeracao(Integer idGeracao) {
		this.idGeracao = idGeracao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getGerado() {
		return gerado;
	}
	public void setGerado(double gerado) {
		this.gerado = gerado;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public int getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	
	
}
