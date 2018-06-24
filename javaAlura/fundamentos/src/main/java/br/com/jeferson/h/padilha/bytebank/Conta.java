package br.com.jeferson.h.padilha.bytebank;

public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private String titular;
	
	public Conta(double saldo, int agencia, int numero, String titular) {
		super();
		this.saldo = saldo;
		this.agencia = agencia;
		this.numero = numero;
		this.titular  = titular;
	}
	
	
	public void deposita(double saldoParam) {
		this.saldo += saldoParam;
	}
	
	public boolean saca(double valorSacar) {
		boolean retorno = false;
		
		if (this.saldo >= valorSacar) {
			this.saldo -= valorSacar;
			retorno = true;
		}
		
		return retorno;
	}
	
	public boolean transfere(double valorTtransferir, Conta contaDestino) {
		boolean retorno = false;
		
		boolean sacou = this.saca(valorTtransferir);
		if (sacou) {
			contaDestino.deposita(valorTtransferir);
			retorno = true;
		}
		
		return retorno;
	}
	
	public double consultaSaldo() {
		return this.saldo;
	}
}
