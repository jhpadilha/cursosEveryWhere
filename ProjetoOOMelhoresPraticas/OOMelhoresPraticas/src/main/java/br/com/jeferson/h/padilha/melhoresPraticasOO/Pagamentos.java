package br.com.jeferson.h.padilha.melhoresPraticasOO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Pagamentos<pag extends Pagamento> implements Iterable<Pagamento>{

  private List<Pagamento> listaPagamentos = new ArrayList<Pagamento>();
  
  public void registraPagamento(pag pagamento){
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
      if (pagamento.qualValorLiquidoPagamento() > valorMinimo) {
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

  public double qualValorPagoAteMomento() {
    double valorTotalPago = 0;
    for (Pagamento pagamento : this.listaPagamentos) {
      valorTotalPago += pagamento.qualValorLiquidoPagamento();
    }
    
    return valorTotalPago;
  }

  @Override
  public Iterator<Pagamento> iterator() {
    return listaPagamentos.iterator();
  }
  
  public ArrayList<Pagamento> pagamentosAntesDeComIterator(Calendar data) {
    ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();

    // veja que agora usamos apenas this
    for (Pagamento pagamento : this) {
      if (pagamento.consultaDataPagamento().before(data)) {
        pagamentosFiltrados.add(pagamento);
      }
    }
    return pagamentosFiltrados;
  }
}
