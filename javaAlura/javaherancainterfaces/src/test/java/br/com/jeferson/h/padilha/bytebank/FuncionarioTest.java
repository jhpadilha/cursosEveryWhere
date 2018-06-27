package br.com.jeferson.h.padilha.bytebank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.jeferson.h.padilha.bytecompany.Diretor;
import br.com.jeferson.h.padilha.bytecompany.Empregado;
import br.com.jeferson.h.padilha.bytecompany.Funcionario;
import br.com.jeferson.h.padilha.bytecompany.Gerente;
import br.com.jeferson.h.padilha.bytecompany.SistemaInterno;
import br.com.jeferson.h.padilha.bytecompany.autenticacao.Autenticavel;

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
    Autenticavel gerente   = new Gerente("Nico Gerente","223355646-9",100.00);
    Autenticavel diretor   = new Diretor("Nico Diretor","223355646-9",100.00);
    
    gerente.setSenhaDesbloqueio(11111);
    diretor.setSenhaDesbloqueio(22222);
    
    //assertTrue("Usuario Empregado nao autenticou !!!", empregado.autentica(0));
    assertTrue("Usuario Gerente nao autenticou !!!", gerente.autenticaSenhaDesbloqueio(11111));
    assertTrue("Usuario Diretor nao autenticou !!!", diretor.autenticaSenhaDesbloqueio(22222));
    assertFalse("Usuario Gerente autenticou !!!", gerente.autenticaSenhaDesbloqueio(1111));
    assertFalse("Usuario Diretor autenticou !!!", diretor.autenticaSenhaDesbloqueio(2222));
    assertFalse("Usuario Gerente autenticou !!!", gerente.autenticaSenhaDesbloqueio(111111));
    assertFalse("Usuario Diretor autenticou !!!", diretor.autenticaSenhaDesbloqueio(222222));
  }
	
	@Test
	  public void desbloqueioFuncionariosTest() throws Exception {
		SistemaInterno sistemaInterno = new SistemaInterno();
		
	    Autenticavel gerente   = new Gerente("Nico Gerente","223355646-9",100.00);
	    Autenticavel diretor   = new Diretor("Nico Diretor","223355646-9",100.00);
	    
	    gerente.setSenhaDesbloqueio(55555);
	    diretor.setSenhaDesbloqueio(55555);
	    
	    assertTrue("Usuario Gerente deveria ter acesso a area restrita !!!", sistemaInterno.desbloqueiaAreaEspecialAcesso(gerente));
	    assertTrue("Usuario Diretor deveria ter acesso a area restrita !!!", sistemaInterno.desbloqueiaAreaEspecialAcesso(diretor));
	    
	    gerente.setSenhaDesbloqueio(5555);
	    diretor.setSenhaDesbloqueio(5555);
	    
	    assertFalse("Usuario Gerente nao deveria ter acesso a area restrita !!!", sistemaInterno.desbloqueiaAreaEspecialAcesso(gerente));
	    assertFalse("Usuario Diretor nao deveria ter acesso a area restrita !!!", sistemaInterno.desbloqueiaAreaEspecialAcesso(diretor));
	    
	    gerente.setSenhaDesbloqueio(555555);
	    diretor.setSenhaDesbloqueio(555555);
	    
	    assertFalse("Usuario Gerente nao deveria ter acesso a area restrita !!!", sistemaInterno.desbloqueiaAreaEspecialAcesso(gerente));
	    assertFalse("Usuario Diretor nao deveria ter acesso a area restrita !!!", sistemaInterno.desbloqueiaAreaEspecialAcesso(diretor));
	  }
	
	@Test
  public void somaTotalBonificacaoTest() throws Exception {
    Funcionario empregado = new Empregado("Nico Empregado","223355646-9", 777.77);
    Funcionario gerente   = new Gerente("Nico Gerente","223355646-9", 777.77);
    Funcionario diretor   = new Diretor("Nico Diretor","223355646-9", 777.77);
    
    ControleBonificacao controleBonificacao = new ControleBonificacao();
    
    controleBonificacao.registraBonificacao(empregado);
    controleBonificacao.registraBonificacao(gerente);
    controleBonificacao.registraBonificacao(diretor);
    
    assertEquals("Valor da soma total da bonificação esta errado !!! ", 0, Double.compare(1011.101, controleBonificacao.getSoma()));
  }
}
