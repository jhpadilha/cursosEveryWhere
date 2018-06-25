package teste;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterNullCollect {

  public static void main(String[] args) {

    StreamFilterNullCollect filterNullCollect = new StreamFilterNullCollect();
    filterNullCollect.testLambda();
    
  }
  
  public void testLambda(){
    System.out.println(" -->> Starting test ...");
    List<String> stringList = new ArrayList<String> ();
    
    stringList.add("1");
    stringList.add("2");
    stringList.add("3");
    stringList.add("4");
    stringList.add("5");
    
    stringList = stringList.stream().filter(str -> str.equals("0")).collect(Collectors.toList());
    
    if ( stringList.isEmpty() ){
      System.out.println(" -->> stringListIsEmpty ...");
    }
    
    System.out.println(" -->> Test finished ...");
  }

}
