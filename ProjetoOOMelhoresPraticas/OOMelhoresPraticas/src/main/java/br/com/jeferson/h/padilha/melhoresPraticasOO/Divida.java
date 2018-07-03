package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.util.function.Consumer;

public class Divida {
	private String credor;
	private Documento cnpjCredor;
	private double total;
	private Pagamentos<Pagamento> pagamentos = new Pagamentos<Pagamento>();

	public void abaterValor(Pagamento pagamento) {
		if (pagamento == null || pagamento.qualValorLiquidoPagamento() <= 0) {
			throw new IllegalArgumentException("Valor inválido de pagamento ! ");
		}

		this.pagamentos.registraPagamento(pagamento);
	}

	public Documento consultaCnpjCredor() {
		return this.cnpjCredor;
	}

	public Divida(double total, String credor, Documento cnpjCredor) {
		super();
		this.total = total;
		this.credor = credor;
		this.cnpjCredor = cnpjCredor;
		Divida person = new Builder()
		        .with( builder  ->  {
		        	
		        } )
		        .build();
	}

	public double valorDivida() {
		return this.total;
	}
	
	public double valorPago() {
		return pagamentos.qualValorPagoAteMomento();
	}

	public String nomeCredor() {
		return credor;
	}
	
	public Pagamentos<Pagamento> getPagamentosRealizados() {
		return pagamentos;
	}

	private static class Builder {
		// put fields builder hear
		public String credor;
		public Documento cnpjCredor;
		public  double total;
		public Pagamentos<Pagamento> pagamentos = new Pagamentos<Pagamento>();

		public Builder with(Consumer<Builder> builderFunction) {
			builderFunction.accept(this);
			return this;
		}

		public Divida build() {
			// call hear contructor params
			return new Divida(total, credor, cnpjCredor);
		}
	}
}
