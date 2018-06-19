package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class BalancoEmpresa {
  
  private Map<Cnpj, Divida> dividas = new HashMap<>();
  
  public void registraDivida(String credor, String cnpjCredor, double valor) {
    Divida divida = new Divida(valor, 0, credor, cnpjCredor);
    
    registraDivida(divida);
  }
  
  public void registraDivida(Divida divida) {
    dividas.put(divida.consultaCnpjCredor(), divida);
  }
  
  public void pagaDivida(String pagador, Cnpj cnpjPagador, Cnpj cnpjCredor, double valor){
    Divida divida = dividas.get(cnpjCredor);
    
    if (divida != null){
      Pagamento pagamento = new Pagamento(pagador, cnpjPagador, valor, Calendar.getInstance());
      divida.abaterValor(pagamento);
    }
  }

  
  
}