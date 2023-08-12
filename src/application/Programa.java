package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import model.ContratoPorHoras;
import model.Departamento;
import model.Trabalhador;
import model.enums.Categoria;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		//Esse metodo cria uma mascara no formato de data que você formate.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departamento = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Categoria Junior ou Senior? ");
		String categoria = sc.nextLine().toUpperCase();
		System.out.print("Salário base: ");
		float salario = Float.parseFloat(sc.nextLine());
		
		Trabalhador trabalhador = new Trabalhador(nome,Categoria.valueOf(categoria),salario,new Departamento(departamento));
		
		System.out.print("Quantos contratos esse trabalhador possui? ");
		int qtd = Integer.parseInt(sc.nextLine());
		 for(int i = 1; i <= qtd; i++) {
			System.out.println("Entre com os dados do " +i+"º contrato");
			System.out.print("Data (DD/MM/YYYY): ");
			Date data = sdf.parse(sc.nextLine());
			System.out.print("Valor por hora: ");
			float valor = Float.parseFloat(sc.nextLine());
			System.out.print("Total de horas: ");
			int horas = Integer.parseInt(sc.nextLine());
			
			ContratoPorHoras contrato = new ContratoPorHoras(data,valor,horas);
			trabalhador.addContrato(contrato);			 
		 }
		 /*Aqui vou pegar o que o usuario vai digitar guardar numa variavel do tipo String e depois
		  * criar duas variaveis do tipo inteiro e usar o metodo substring pra recortar a string e 
		  * usar o Integer para transforma pra inteiro.
		  */
		 System.out.println("Entre com o mês e o ano para o calculo do salário (MM/YYYY): ");
		 String mesEano = sc.nextLine();
		 int mes = Integer.parseInt(mesEano.substring(0,2));
		 int ano = Integer.parseInt(mesEano.substring(3));
		 System.out.println("Nome: "+ trabalhador.getNome());
		 System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		 System.out.println("Salário referente a: "+mesEano+" R$"+String.format("%.2f",trabalhador.renda(ano, mes)));
	
		
		sc.close();
	}

}
