package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class RelatorioDivida {
	
	private Divida divida;
	private NumberFormat formatador;

	public RelatorioDivida(Divida divida, NumberFormat formatador) {
		this.divida = divida;
		this.formatador = formatador;
	}

	public Divida getDivida() {
		return divida;
	}

	public void setDivida(Divida divida) {
		this.divida = divida;
	}
	
	public void geraRelatorio() {
		System.out.println("Cnpj credor : " + divida.consultaCnpjCredor());
		System.out.println("Nome credor : " + divida.nomeCredor());
		
		System.out.println("Valor da dívida : " + formatador.format(divida.valorDivida()));
		System.out.println("Valor pago da dívida até o momento : " + formatador.format(divida.valorPago()));
		System.out.println("");
	}
	
	public static void main(String[] args) {
		RelatorioDivida relatorioDivida;
		NumberFormat formatador  =  NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		// new Locale("en", "US")
		
		Pagamento pagamento1 = new Pagamento("Jef", new Cnpj("00682512036"), 10, Calendar.getInstance());
		Pagamento pagamento2 = new Pagamento("Jef", new Cnpj("00682512036"), 10, Calendar.getInstance());
	    Divida divida = new Divida(100, "Jeferson H P", "111222333444");
	    
	    divida.abaterValor(pagamento1);
	    divida.abaterValor(pagamento2);
	    
	    relatorioDivida = new RelatorioDivida(divida, formatador);
	    relatorioDivida.geraRelatorio();
	    
	    Iterable<Pagamento> listaPagsIteravel = divida.getPagamentosRealizados();
	    int numPagamento = 1;
	    for (Pagamento pagamento : listaPagsIteravel) {
			System.out.println(String.format("Pagamento numero %d no valor de %s.", numPagamento, formatador.format(pagamento.qualValorLiquidoPagamento())));
			numPagamento++;
		}
	}

}
