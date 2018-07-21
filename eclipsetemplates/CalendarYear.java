package testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarYear {

  public static void main(String[] args) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
    
    Calendar dataLimiteFPE = Calendar.getInstance();
    dataLimiteFPE.set(Calendar.HOUR_OF_DAY, 0);
    dataLimiteFPE.set(Calendar.MINUTE, 0);
    dataLimiteFPE.set(Calendar.SECOND, 0);
    dataLimiteFPE.set(Calendar.MILLISECOND, 0);
    
    dataLimiteFPE.set(Calendar.DAY_OF_MONTH, 31);
    dataLimiteFPE.set(Calendar.MONTH, 11); //jan = 0
    dataLimiteFPE.set(Calendar.YEAR, 2078);
    System.out.println("#0. " + sdf.format(dataLimiteFPE.getTime()));
    

    Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
    System.out.println("#1. " + sdf.format(calendar.getTime()));

    //update a date
    calendar.set(Calendar.YEAR, 2014);
    calendar.set(Calendar.MONTH, 11);
    calendar.set(Calendar.MINUTE, 33);

    System.out.println("#2. " + sdf.format(calendar.getTime()));
    
    System.out.println("#3. " + sdf.format(dataLimiteFPE.getTime()));

  }

}
