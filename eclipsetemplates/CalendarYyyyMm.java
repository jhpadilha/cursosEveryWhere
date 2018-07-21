package testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarYyyyMm {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
    SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss SSS");
    try {
      Date data = sdf.parse("11/2014");
      System.out.println(sdfOut.format(data));
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
