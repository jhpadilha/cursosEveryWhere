package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pagamentos<pag extends Pagamento> {

  private double valorPago;
  private List<Pagamento> listaPagamentos = new ArrayList<Pagamento>();
  
  public void registraPagamento(pag pagamento){
    this.valorPago = this.valorPago + pagamento.consultaValorEfetivo();
    
    this.listaPagamentos.add(pagamento);
  }
  
  public ArrayList<Pagamento> pagamentosAntesDe(Calendar data) {
    ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
    for (Pagamento pagamento : this.listaPagamentos) {
      if (pagamento.consultaDataPagamento().before(data)) {
        pagamentosFiltrados.add(pagamento);
      }
    }
    return pagamentosFiltrados;
  }
  public ArrayList<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
    ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
    for (Pagamento pagamento : this.listaPagamentos) {
      if (pagamento.consultaValorEfetivo() > valorMinimo) {
        pagamentosFiltrados.add(pagamento);
      }
    }
    return pagamentosFiltrados;
  }
  public ArrayList<Pagamento> pagamentosDo(String cnpjPagador) {
    ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
    for (Pagamento pagamento : this.listaPagamentos) {
      if (pagamento.getCnpjPagador().equals(cnpjPagador)) {
        pagamentosFiltrados.add(pagamento);
      }
    }
    return pagamentosFiltrados;
  }
}
