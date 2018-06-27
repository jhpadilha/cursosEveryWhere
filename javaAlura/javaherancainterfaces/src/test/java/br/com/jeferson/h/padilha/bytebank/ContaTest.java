package br.com.jeferson.h.padilha.bytebank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.jeferson.h.padilha.bytebank.Cliente;
import br.com.jeferson.h.padilha.bytebank.Conta;
import br.com.jeferson.h.padilha.bytebank.tributos.Tributavel;

public class ContaTest {
  
  @Test
  public void primeiraConta() throws Exception {
    Cliente clientePaulo = new Cliente("Paulo", "00099988887777", "Professor");
    Conta primeiraConta = new ContaCorrente(0, 111, 111444777, clientePaulo);
    primeiraConta.deposita(200);
    
    System.out.println(primeiraConta.consultaSaldo());
    
    assertEquals("Valor saldo incorreto ! ", 0, Double.compare(200, primeiraConta.consultaSaldo()));
  }
  
  @Test
  public void referenciaTest() throws Exception {
    Cliente clientePaulo = new Cliente("Paulo", "00099988887777", "Professor");
    Conta primeiraConta = new ContaCorrente(0, 111, 111444777, clientePaulo);
    primeiraConta.deposita(200);
    
    System.out.println("saldo primeira conta : " + primeiraConta.consultaSaldo());
    
    Conta segundaConta = primeiraConta;
    System.out.println("saldo segunda conta : " + segundaConta.consultaSaldo());
    
    segundaConta.deposita(200);
    System.out.println("saldo segunda conta : " + segundaConta.consultaSaldo());
    System.out.println("saldo primeira conta : " + primeiraConta.consultaSaldo());
    
    if (primeiraConta == segundaConta) {
      System.out.println("São a mesmíssima conta !");
    }else {
      System.out.println("Não são a mesma conta !");
    }
    
    assertEquals("Valor saldo incorreto ! ", 0, Double.compare(400, primeiraConta.consultaSaldo()));
  }
	
	@Test
	public void transferenciaTest() throws Exception {
		Cliente clientePaulo = new Cliente("Paulo", "00099988887777", "Professor");
		Cliente clienteJoao  = new Cliente("Joao",  "88899988887777", "Carteiro");
		
		Conta contaCorrente =  new ContaCorrente(222, 111, 111444777, clientePaulo);
		Conta contaPoupanca = new ContaPoupanca(111, 111, 111444777, clienteJoao);
		
		contaCorrente.transfere(111, contaPoupanca);
		
		assertEquals("O saldo da conta de origem  esta incorreto, 138.75 - " + contaCorrente.consultaSaldo(), 0, Double.compare(138.75, contaCorrente.consultaSaldo()));
		assertEquals("O saldo da conta de destino esta incorreto, 194.25 - " + contaPoupanca.consultaSaldo(), 0, Double.compare(194.25, contaPoupanca.consultaSaldo()));
	}
	
	@Test
  public void calculoTributosTest() throws Exception {
    Cliente clientePaulo = new Cliente("Paulo", "00099988887777", "Professor");
    Tributavel contaCorrente = new ContaCorrente(100, 111, 111444777, clientePaulo);
    
    Tributavel seguroVida = new SeguroVida();
    
    TotalizadoraTributos calculadoraTributos = new TotalizadoraTributos();
    calculadoraTributos.registraTributos(contaCorrente);
    calculadoraTributos.registraTributos(seguroVida);
    
    
    assertEquals("O valor total de tributos esta incorreto, 43 - " + calculadoraTributos.getTotalTributos(), 0, Double.compare(43, calculadoraTributos.getTotalTributos()));
  }
}
