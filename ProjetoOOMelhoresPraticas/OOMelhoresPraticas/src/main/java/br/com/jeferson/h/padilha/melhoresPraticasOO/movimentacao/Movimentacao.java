package br.com.jeferson.h.padilha.melhoresPraticasOO.movimentacao;

import java.util.Calendar;

public abstract class Movimentacao {

	protected double valor;
	private Conta conta;
	private Calendar data;

	public Movimentacao(double valor, Conta conta, Calendar data) {
		this.valor = valor;
		this.conta = conta;
		this.data = data;
		// TODO Auto-generated constructor stub
	}
	
	abstract double getEncargos();

}
