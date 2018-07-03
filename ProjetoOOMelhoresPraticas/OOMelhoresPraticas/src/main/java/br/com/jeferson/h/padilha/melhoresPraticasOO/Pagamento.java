package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.util.Calendar;

public class Pagamento {
  private String pagador;
  private Cnpj cnpjPagador;
  private double valorPagamento;
  private double valorEfetivo;
  private Calendar dataPagamento;
  
  public String getPagador() {
    return pagador;
  }
  public String getCnpjPagador() {
    return cnpjPagador.getValor();
  }
  
  public double qualValorLiquidoPagamento(){
    return valorEfetivo;
  }
  
  public Calendar consultaDataPagamento(){
    return dataPagamento;
  }
  
  public Pagamento(String pagador, Cnpj cnpjPagador, double valor, Calendar dataPagamento) {
    super();
    this.pagador = pagador;
    this.cnpjPagador = cnpjPagador;
    this.valorPagamento = valor;
    this.valorEfetivo = calculaValorHaSerAbatido(valor);
    this.dataPagamento = dataPagamento;
  }
  
  private double calculaValorHaSerAbatido(double valor) {
    double valorHaSerAbatido = 0;
    
    if (valor < 100){
      valorHaSerAbatido = valor - (valor * 0.10);
    } else {
      valorHaSerAbatido = valor;
    }
    return valorHaSerAbatido;
  }
}
