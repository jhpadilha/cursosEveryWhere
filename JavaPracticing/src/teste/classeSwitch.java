package teste;

public class classeSwitch {
  
  public static void main(String[] args) {
    Integer tipoInfracaoAnalitica = 3;
    Integer teste = teste(tipoInfracaoAnalitica);
    System.out.println(teste);
  }

  private static Integer teste(Integer tipoInfracaoAnalitica) {
    switch (tipoInfracaoAnalitica) {
      case 0:
        return 0;
      case 1: 
      case 2:  
        return 12;
    }
    return null;
  }

}
