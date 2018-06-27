package br.com.jeferson.h.padilha.bytebank;

public class ControleBonificacao {
  
  private double soma;
  
  public ControleBonificacao() {
    soma = 0;
  }
  
  public boolean registraBonificacao(Funcionario funcionario){
    boolean retorno = false;
    if (funcionario != null){
      this.soma += funcionario.getBonificacao();
      retorno = true;
    }
    
    return retorno;
  }
  
  public double getSoma() {
    return soma;
  }

}