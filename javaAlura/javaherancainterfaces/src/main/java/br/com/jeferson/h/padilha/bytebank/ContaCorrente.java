package br.com.jeferson.h.padilha.bytebank;

public class ContaCorrente extends Conta {

  public ContaCorrente(){
    super();
  }

  public ContaCorrente(double saldo, int agencia, int numero, Cliente titular) {
    super(saldo, agencia, numero, titular);
  }

  @Override
  public double getDecimalPercentualJurosOperacao(){
    return 0.25;
  }
}
