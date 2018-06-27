package br.com.jeferson.h.padilha.bytebank;

import br.com.jeferson.h.padilha.bytebank.tributos.Tributavel;

public class ContaCorrente extends Conta implements Tributavel{

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

  public double calculaTributos() {
    return this.consultaSaldo() * 0.01;
  }
}
