package br.com.jeferson.h.padilha.fundamentos;

public class FatorialTest {
  
  public static void main(String ... args) {

    for(int descobrirFatorial = 0 ; descobrirFatorial <= 10 ; descobrirFatorial++ ){
      
      int fatorial = descobrirFatorial(descobrirFatorial);
      System.out.println(String.format("O fatorial de %d é %d .", descobrirFatorial, fatorial));
      
    }
    

  }

  private static int descobrirFatorial(int descobrirFatorial) {
    int fatorial = 1;
    
    for(int contadorFatorial = descobrirFatorial ; contadorFatorial > 0 ; contadorFatorial -- ){
      fatorial *= contadorFatorial;
      //System.out.println(contadorFatorial + " - " + fatorial);
    }
    return fatorial;
  }

}
