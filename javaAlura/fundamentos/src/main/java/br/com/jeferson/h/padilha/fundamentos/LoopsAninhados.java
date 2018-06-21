package br.com.jeferson.h.padilha.fundamentos;

public class LoopsAninhados {

  public static void main(String[] args) {
    for (int fatorMultiplicacao = 1 ; fatorMultiplicacao <= 10 ; fatorMultiplicacao ++ ){
      System.out.print(String.format("Resultado do fator de multiplicação %d:\t", fatorMultiplicacao) );
      for(int elementoMultiplicado = 0 ; elementoMultiplicado <= 10 ; elementoMultiplicado ++){
        System.out.print(fatorMultiplicacao * elementoMultiplicado + String.format(" (%d * %d)", fatorMultiplicacao,elementoMultiplicado) + ";\t");
      }
      System.out.println();
    }
    
    for (int linha = 1 ; linha <= 10 ; linha ++){
      for (int coluna = 1 ; coluna <=10 ; coluna ++){
        if(linha>=coluna){
          System.out.print("*");
        }
      }
      System.out.println();
    }
    
    System.out.println("===========");
    System.out.println("=====================");
    System.out.println("==============================");
    System.out.println("=====================");
    System.out.println("===========");
    
    for (int linha = 1 ; linha <= 10 ; linha ++){
      for (int coluna = 1 ; coluna <=10 ; coluna ++){
        if(linha<=coluna){
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }
  
}
