package br.com.jeferson.h.padilha.melhoresPraticasOO;

public class Divida {
  private String credor;
  private Cnpj cnpjCredor;
  private double total;
  private Pagamentos<Pagamento> pagamentos = new Pagamentos<Pagamento>(); 

  public void abaterValor(Pagamento pagamento) {
    if (pagamento == null || pagamento.consultaValorEfetivo() <= 0) {
      throw new IllegalArgumentException("Valor inválido de pagamento ! ");
    }
    
    this.pagamentos.registraPagamento(pagamento);
  }

  public Cnpj consultaCnpjCredor(){
    return this.cnpjCredor;
  }
  
  public Divida(double total, double valorPago, String credor, String cnpjCredor) {
    super();
    this.total = total;
    this.credor = credor;
    this.cnpjCredor = new Cnpj(cnpjCredor);
  }
}

