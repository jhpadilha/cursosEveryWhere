import static junit.framework.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import br.com.jeferson.h.padilha.melhoresPraticasOO.Cnpj;
import br.com.jeferson.h.padilha.melhoresPraticasOO.Pagamento;
import br.com.jeferson.h.padilha.melhoresPraticasOO.Pagamentos;

public class TestPagamentos {
  
  @Test 
  public void testaValorPagamento(){
    Pagamentos<Pagamento> pags = new Pagamentos<Pagamento>();
    
    Pagamento pagamento1 = new Pagamento("Jef", new Cnpj("00682512036"), 100, Calendar.getInstance());
    Pagamento pagamento2 = new Pagamento("Jef", new Cnpj("00682512036"), 122, Calendar.getInstance());
    
    pags.registraPagamento(pagamento1);
    pags.registraPagamento(pagamento2);
    
    double valorPagoAteMomento = pags.qualValorPagoAteMomento();
    
    System.out.println(valorPagoAteMomento);
    
    assertEquals("O calculo do valoe de pagamento está incorreto", 222.0, valorPagoAteMomento);    
  }

}
