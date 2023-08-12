package model;

import java.util.Date;

public class ContratoPorHoras {
	private Date data;
	private float valorPorHora;
	private float horas;
	
	public ContratoPorHoras() {
		
	}
	public ContratoPorHoras(Date data, float valorPorHora, float horas) {
		super();
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getValorPorHora() {
		return valorPorHora;
	}
	public void setValorPorHora(float valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	public float getHoras() {
		return horas;
	}
	public void setHoras(float horas) {
		this.horas = horas;
	}
	public float valorTotal() {
		return horas * valorPorHora;
	}
	

}
