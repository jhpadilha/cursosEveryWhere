package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import br.com.jeferson.h.padilha.melhoresPraticasOO.Cnpj;
import br.com.jeferson.h.padilha.melhoresPraticasOO.Divida;
import br.com.jeferson.h.padilha.melhoresPraticasOO.Pagamento;

public class BalancoEmpresa {
  
  private Map<Documento, Divida> dividas = new HashMap<Documento, Divida>();
  
  public void registraDivida(String credor, String cnpjCredor, double valor) {
	  
    Divida divida = new Divida(valor, credor, new Cnpj(cnpjCredor));
    
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
