package br.com.jeferson.h.padilha.bytebank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FuncionarioTest {

	@Test        
	public void inicioTest() throws Exception {
		Funcionario nico = new Empregado("Nico Steppat","223355646-9",2600.00);

    System.out.println(nico.getNome());
    System.out.println(nico.getBonificacao());
    
    assertTrue("O nome esta incorreto", "Nico Steppat".equals(nico.getNome()));
    assertEquals("Salario incorreto", 0, Double.compare(2600.0, nico.getSalario()));

	}
	
	@Test
	public void valoresRemuneracaoTest() throws Exception {
	  Funcionario empregado = new Empregado("Nico Empregado","223355646-9",100.00);
	  Funcionario gerente   = new Gerente("Nico Gerente","223355646-9",100.00);
	  Funcionario diretor   = new Diretor("Nico Diretor","223355646-9",100.00);
	  
	  assertEquals("VAlor de remuneração do empregado incorreto !!! ", 0, Double.compare(10.0, empregado.getBonificacao()));
	  assertEquals("VAlor de remuneração do gerente incorreto !!! ",   0, Double.compare(45.0, gerente.getBonificacao()));
	  assertEquals("VAlor de remuneração do diretor incorreto !!! ",   0, Double.compare(75.0, diretor.getBonificacao()));
  }
	
	@Test
  public void valoresRemuneracaoQuebradosTest() throws Exception {
    Funcionario empregado = new Empregado("Nico Empregado","223355646-9", 777.77);
    Funcionario gerente   = new Gerente("Nico Gerente","223355646-9", 777.77);
    Funcionario diretor   = new Diretor("Nico Diretor","223355646-9", 777.77);
    
    assertEquals("VAlor de remuneração do empregado incorreto !!! ", 0, Double.compare(77.777, empregado.getBonificacao()));
    assertEquals("VAlor de remuneração do gerente incorreto !!! ",   0, Double.compare(349.9965, gerente.getBonificacao()));
    assertEquals("VAlor de remuneração do diretor incorreto !!! ",   0, Double.compare(583.3275, diretor.getBonificacao()));
  }
	
	@Test
  public void autenticacaoFuncionariosTest() throws Exception {
    Funcionario empregado = new Empregado("Nico Empregado","223355646-9",100.00);
    Funcionario gerente   = new Gerente("Nico Gerente","223355646-9",100.00);
    Funcionario diretor   = new Diretor("Nico Diretor","223355646-9",100.00);
    
    assertTrue("Usuario Empregado nao autenticou !!!", empregado.autentica(0));
    assertTrue("Usuario Gerente nao autenticou !!!", gerente.autentica(11111));
    assertTrue("Usuario Diretor nao autenticou !!!", diretor.autentica(22222));
  }
}
