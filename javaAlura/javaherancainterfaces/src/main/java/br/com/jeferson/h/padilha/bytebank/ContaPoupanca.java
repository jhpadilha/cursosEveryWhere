package br.com.jeferson.h.padilha.bytebank;

public class ContaPoupanca extends Conta {

  public ContaPoupanca(){
    super();
  }
  
  public ContaPoupanca(double saldo, int agencia, int numero, Cliente titular) {
    super(saldo, agencia, numero, titular);
  }
  
  @Override
  public double getDecimalPercentualJurosOperacao(){
    return 0.10;
  }
}
