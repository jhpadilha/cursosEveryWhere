package br.com.jeferson.h.padilha.melhoresPraticasOO.movimentacao;

import java.util.Calendar;

public class Deposito extends Movimentacao {

	private String numeroEnvelope;

	public Deposito(double valor, Conta conta, Calendar data, String numeroEnvelope) {
		super(valor, conta, data);
		this.numeroEnvelope = numeroEnvelope;
	}

	public double getEncargos() {
		throw new RuntimeException("Depositos não sofrem encargos");
	}
}
