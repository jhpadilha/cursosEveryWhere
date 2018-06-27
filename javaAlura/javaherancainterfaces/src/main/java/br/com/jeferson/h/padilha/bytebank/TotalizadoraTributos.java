package br.com.jeferson.h.padilha.bytebank;

import br.com.jeferson.h.padilha.bytebank.tributos.Tributavel;

public class TotalizadoraTributos {
 
  private double totalTributos;
  
  public void registraTributos(Tributavel tributavel){
    totalTributos += tributavel.calculaTributos();
  }
  
  public double getTotalTributos() {
    return totalTributos;
  }

}
