package br.com.jeferson.h.padilha.assalariado;

public class Funcionario implements Assalariado {
  public void paga(double valor) { // antigo public void depositaNaConta(double valor)
    // código continua igual
  }
  public double getSalarioBase() { // antigo public double getSalario()
    // ...
    return 0;
  }
  public double getExtras() { // antigo public void getBonus()
    // código continua igual
    return 0;
  }
  // outros métodos
}