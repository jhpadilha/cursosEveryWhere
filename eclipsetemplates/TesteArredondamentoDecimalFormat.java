package testes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TesteArredondamentoDecimalFormat {

  public static void main(String[] args) {
    Float a = new Float("10.12345");
    
    formatar(a);
    
    
    System.out.println();
    a = new Float("10.9999");
    formatar(a);
    
    System.out.println();
    a = new Float("10.8888");
     formatar(a);
    
    System.out.println();
    a = new Float("10.7777");
    formatar(a);
    
    System.out.println();
    a = new Float("10.6666");
    formatar(a);
    
    System.out.println();
    a = new Float("10.5555");
    formatar(a);
    
    System.out.println();
    a = new Float("10.4444");
    formatar(a);
    
    System.out.println();
    a = new Float("10.3333");
    formatar(a);
    
    System.out.println();
    a = new Float("10.2222");
    formatar(a);
    
    System.out.println();
    a = new Float("10.11111");
    formatar(a);
    
    System.out.println();
    a = new Float("10.99");
    formatar(a);
    
    System.out.println();
    a = new Float("10.88");
     formatar(a);
    
    System.out.println();
    a = new Float("10.77");
    formatar(a);
    
    System.out.println();
    a = new Float("10.66");
    formatar(a);
    
    System.out.println();
    a = new Float("10.55");
    formatar(a);
    
    System.out.println();
    a = new Float("10.44");
    formatar(a);
    
    System.out.println();
    a = new Float("10.33");
    formatar(a);
    
    System.out.println();
    a = new Float("10.22");
    formatar(a);
    
    System.out.println();
    a = new Float("10.11");
    formatar(a);
    
   
  }

  private static void formatar(Float a) {
    DecimalFormat df = new DecimalFormat("#0000000000.00");
    df.setMaximumFractionDigits(2);
    df.setMinimumFractionDigits(0);
    
    df.setRoundingMode(RoundingMode.CEILING);
    System.out.println("CEILING \t" + df.format(a));
    df.setRoundingMode(RoundingMode.DOWN);
    System.out.println("DOWN \t\t" + df.format(a));
    df.setRoundingMode(RoundingMode.FLOOR);
    System.out.println("FLOOR \t\t" + df.format(a));
    df.setRoundingMode(RoundingMode.HALF_DOWN);
    System.out.println("HALF_DOWN \t" + df.format(a));
    df.setRoundingMode(RoundingMode.HALF_EVEN);
    System.out.println("HALF_EVEN \t" + df.format(a));
    df.setRoundingMode(RoundingMode.HALF_UP);
    System.out.println("HALF_UP \t" + df.format(a));
    df.setRoundingMode(RoundingMode.UP);
    System.out.println("UP \t\t" + df.format(a));
    
    
    int precision = 100; //keep 4 digits
    System.out.println("Math.floor \t\t" + (Math.floor(a * precision +.5f)/precision));
    
    System.out.println("Strfmt %.2f \t"+String.format("%.2f", a));
    
    System.out.println("Math.round \t" + Math.round(a * 100f) / 100f);
    
    System.out.println("roundFloat \t" + ((int)((a*100f)+0.5f))/100f);
    
    BigDecimal bg = new BigDecimal(a);
    bg.setScale(2, RoundingMode.DOWN);
    
    System.out.println("BigDecRound \t" + String.format("%014.2f", bg.setScale(2, RoundingMode.DOWN)));
    
    System.out.println("BigDecStr \t" + String.format("%1$" + bg.setScale(2, RoundingMode.DOWN).toPlainString() + "s", 14).replaceAll(" ",  "0"));
    
    df.setRoundingMode(RoundingMode.DOWN);
    System.out.println("DOWN Big \t" + df.format(bg.setScale(2, RoundingMode.DOWN)));
    
    System.out.print(".2f + 0.005 \t");
    System.out.printf("%.2f", a + 0.005);
    
    System.out.print(".2f - 0.005 \t");
    System.out.printf("%.2f", a - 0.005);
    
    System.out.printf("\n");
    
  }

}
