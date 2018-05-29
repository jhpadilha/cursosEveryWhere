package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.util.Calendar;

public class GerenciadorDeDividas {

  public void efetuarPagamento(Divida divida, String pagador, Cnpj cnpjPagador, double valor){
    Pagamento pagamento = new Pagamento(pagador, cnpjPagador, valor, Calendar.getInstance());
    
    this.efetuarPagamento(divida, pagamento);
  }
  
  public void efetuarPagamento(Divida divida, Pagamento pagamento){
    
    if (divida != null){
      divida.abaterValor(pagamento);
    }
  }
  
}
