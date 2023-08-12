package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.enums.Categoria;

public class Trabalhador {
	private String nome;
	private Categoria categoria;
	private float salarioBase;
	/*
	 * Aqui estão as associções, ou composição de objetos 
	 */
	private Departamento departamento;
	private List<ContratoPorHoras> contratos = new ArrayList<>();
	
	public Trabalhador() {
		
	}	
	public Trabalhador(String nome, Categoria categoria, float salarioBase, Departamento departamento) {		
		this.nome = nome;
		this.categoria = categoria;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public float getSalarioBase() {
		return salarioBase;
	}
	public List<ContratoPorHoras> getContratos() {
		return contratos;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}
	/*Esses dois metodos de adicionar e remover são responsaveis por fazer ou desfazer a associação de um trabalhador
	 * com um contrato
	 */
	public void addContrato(ContratoPorHoras contrato) {
		contratos.add(contrato);
	}
	public void removerContrato(ContratoPorHoras contrato) {
		contratos.remove(contrato);
	}
	/*esse metodo fica responsavel por fazer a soma total de todos os contratos que estiverem nos parametros
	 * passados no metodo(ano/mês) Foi criados dois atributos para pegar o ano e o mês para fazer a comparação 
	 * dentro do 'for'e se tiver na lista uma data igual, a variavel soma é atualizada com o valor que vem do metodo.
	 */
	public float renda(Integer ano, Integer mes) {
		float soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoPorHoras contrat: contratos) {
			cal.setTime(contrat.getData());
			int ano_contrat = cal.get(Calendar.YEAR) ;
			int mes_contrat = 1+ cal.get(Calendar.MONTH);
			if (ano == ano_contrat && mes == mes_contrat) {
				soma += contrat.valorTotal();
			}
		}
	return soma;
	}
	
}
