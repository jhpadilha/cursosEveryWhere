package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle {

	private SubControle() {
		// TODO Auto-generated constructor stub
	}
	
	public  SubControle(String teste) {
		// TODO Auto-generated constructor stub
	}
	
	public void metodoSubControle1() {
		System.out.println("metodoSubControle1 was executed ...");
	}
	
	private String metodoSubControle2() {
		String retorno = "metodoSubControle2 was executed ...";
		System.out.println(retorno);
		return "metodoSubControle2 was done ...";
	}
}
