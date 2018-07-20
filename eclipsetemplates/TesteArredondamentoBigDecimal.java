package testes;

import java.math.BigDecimal;

public class TesteArredondamentoBigDecimal {

  public static void main(String[] args) {
    BigDecimal a = new BigDecimal("10.12345");

    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    
    System.out.println();
    a = new BigDecimal("10.9999");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.8888");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.7777");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.6666");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.5555");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.4444");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.3333");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.2222");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
    
    System.out.println();
    a = new BigDecimal("10.11111");
    System.out.println(a.setScale(2, BigDecimal.ROUND_UP));
    System.out.println(a.setScale(2, BigDecimal.ROUND_CEILING));
    System.out.println(a.setScale(2, BigDecimal.ROUND_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_FLOOR));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_EVEN));
    System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_UP));
  }

}
