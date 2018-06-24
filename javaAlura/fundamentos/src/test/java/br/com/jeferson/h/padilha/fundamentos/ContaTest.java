package br.com.jeferson.h.padilha.fundamentos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.jeferson.h.padilha.bytebank.Cliente;
import br.com.jeferson.h.padilha.bytebank.Conta;

public class ContaTest {

	@Test
	public void primeiraConta() throws Exception {
		Cliente clientePaulo = new Cliente("Paulo", "00099988887777", "Professor");
		Conta primeiraConta = new Conta(0, 111, 111444777, clientePaulo);
		primeiraConta.deposita(200);
		
		System.out.println(primeiraConta.consultaSaldo());
		
		assertEquals("Valor saldo incorreto ! ", 0, Double.compare(200, primeiraConta.consultaSaldo()));
	}
	
	@Test
	public void referenciaTest() throws Exception {
		Cliente clientePaulo = new Cliente("Paulo", "00099988887777", "Professor");
		Conta primeiraConta = new Conta(0, 111, 111444777, clientePaulo);
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
		
		Conta contaOrigem =  new Conta(222, 111, 111444777, clientePaulo);
		Conta contaDestino = new Conta(111, 111, 111444777, clienteJoao);
		
		contaOrigem.transfere(111, contaDestino);
		
		assertEquals("O saldo da conta de origem  esta incorreto", 0, Double.compare(111, contaOrigem.consultaSaldo()));
		assertEquals("O saldo da conta de destino esta incorreto", 0, Double.compare(222, contaDestino.consultaSaldo()));
	}
}
