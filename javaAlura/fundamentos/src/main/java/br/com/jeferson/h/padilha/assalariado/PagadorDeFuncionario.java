package br.com.jeferson.h.padilha.assalariado;

public class PagadorDeFuncionario {
  public void pagaAssalariado(Assalariado assalariado) {
    assalariado.paga(assalariado.getSalarioBase() + assalariado.getExtras());
  }
}
