package br.com.jeferson.h.padilha.bytebank;

public abstract class Conta {
	
	private static int numeroContas = 0;
	
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	
	public Conta() {
		super();
		inicializaDados();
	}

	public Conta(double saldo, int agencia, int numero, Cliente titular) {
		this();
		
		this.saldo = saldo;
		this.agencia = agencia;
		this.numero = numero;
		this.titular  = titular;
	}

	public abstract double getDecimalPercentualJurosOperacao();
	
	private void inicializaDados() {
		Conta.addNumeroContas();
	}
	
	private static void addNumeroContas() {
		Conta.numeroContas += 1;
	}
	
	private static int getNumeroContas() {
		return Conta.numeroContas;
	}
	
	public void deposita(double saldoParam) {
		this.saldo += saldoParam;
	}
	
	public boolean saca(double valorSacar) {
		boolean retorno = false;
		
		double valorJaDescontadoJurosOperacao = calculaValorJaDescontadoJurosOperacao(valorSacar);
		
		if (this.saldo >= valorJaDescontadoJurosOperacao) {
			this.saldo -= valorJaDescontadoJurosOperacao;
			retorno = true;
		}
		
		return retorno;
	}
	
	public boolean transfere(double valorTtransferir, Conta contaDestino) {
		boolean retorno = false;
		
		boolean sacou = this.saca(valorTtransferir);
		if (sacou) {
			contaDestino.deposita(calculaValorJaDescontadoJurosOperacao(valorTtransferir));
			retorno = true;
		}
		
		return retorno;
	}
	
	private double calculaJurosOperacao(double valorSacar) {
	  return valorSacar * getDecimalPercentualJurosOperacao();
	}
	
	private double calculaValorJaDescontadoJurosOperacao(double valorSacar) {
    double jurosOperacao = calculaJurosOperacao(valorSacar);
    
    return valorSacar - jurosOperacao;
  }

	public double consultaSaldo() {
		return this.saldo;
	}
}
