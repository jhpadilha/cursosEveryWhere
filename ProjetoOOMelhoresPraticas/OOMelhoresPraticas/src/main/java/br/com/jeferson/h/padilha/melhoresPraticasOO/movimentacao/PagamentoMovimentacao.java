package br.com.jeferson.h.padilha.melhoresPraticasOO.movimentacao;

import java.util.Calendar;

public class PagamentoMovimentacao extends Movimentacao {

	private String favorecido;
	private String formaDePagamento;

	public PagamentoMovimentacao(double valor, Conta conta, Calendar data, String favorecido, String formaDePagamento) {
		super(valor, conta, data);
		this.favorecido = favorecido;
		this.formaDePagamento = formaDePagamento;
	}

	public double getEncargos() {
		return valor * 0.01;
	}

}
