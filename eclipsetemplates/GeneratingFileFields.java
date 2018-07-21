package testes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GeneratingFileFields {
  
  private String rightSubstr(String value, Integer length){
    return value.substring(0, length);
  }
  
  private String leftSubstr(String value, Integer length){
    Integer valueLength = value.length();
    Integer initPosition = valueLength - length;
    if (initPosition < 0){
      return value;
    }
    
    return value.substring(initPosition);
  }
  
  private String createStringField(String value, Integer length){
    String valueFormat = String.format("%1$-" + length + "s", value);
    return rightSubstr(valueFormat, length);  
  }
  
  private String createNumberField(Number value, Integer length){
    String valueFormat = String.format("%0" + (length) + "d", 0);
    DecimalFormat df = new DecimalFormat(valueFormat);
    df.setRoundingMode(RoundingMode.DOWN);
    
    String valueFormated = df.format(value);
    return leftSubstr(valueFormated, length) ;
  }
  
  
  private String createFloatingNumberField(Number value, Integer length, Integer decimalPlaces){
    String formatBeforeDot = String.format("%0" + (length - decimalPlaces) + "d", 0);
    String dot = ".";
    String formatAfterDot = String.format("%0" + (decimalPlaces) + "d", 0);
    
    DecimalFormat df = new DecimalFormat(formatBeforeDot + dot + formatAfterDot);
    df.setRoundingMode(RoundingMode.DOWN);
    
    return leftSubstr(df.format(value).replace(".", "").replace(",", ""), length);
  }
  
  private String createDateAAAAMMDDField(Date data){
    return new SimpleDateFormat("yyyyMMdd").format(data);
  }
  
  public GeneratingFileFields() {
    System.out.println("");
    System.out.println("#" + createStringField("teste", 50) + "#");
    System.out.println("#" + createNumberField(55, 10) + "#");
    System.out.println("#" + createNumberField(77l, 10) + "#");
    System.out.println("#" + createDateAAAAMMDDField(Calendar.getInstance().getTime()) + "#");
    System.out.println("#" + createFloatingNumberField(77.77d, 12, 2) + "#");
    System.out.println("#" + createFloatingNumberField(77.77f, 12, 2) + "#");
    System.out.println("#" + createFloatingNumberField(new BigDecimal(12.12), 12, 2) + "#");
    
    System.out.println("");
    System.out.println("######################");
    System.out.println("");
    
    System.out.println("#" + createStringField("testetestetestetestetestetestetestetesteteste12345XXXXXXXXXX", 50) + "#");
    System.out.println("#" + createNumberField(881234567890l, 10) + "#");
    System.out.println("#" + createDateAAAAMMDDField(Calendar.getInstance().getTime()) + "#");
    System.out.println("#" + createFloatingNumberField(777777777777777.77d, 12, 2) + "#");
    System.out.println("#" + createFloatingNumberField(77.77f, 12, 2) + "#");
    System.out.println("#" + createFloatingNumberField(new BigDecimal(12.12), 12, 2) + "#");
  }
  
  public static void main(String[] args) {
    new GeneratingFileFields();
  }
}
