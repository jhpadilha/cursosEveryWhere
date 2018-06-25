package br.com.jeferson.h.padilha.bytebank;

import static org.junit.Assert.*;

import org.junit.Test;

public class FuncionarioTest {

	@Test
	public void inicioTest() throws Exception {
		Funcionario nico = new Funcionario("Nico Steppat","223355646-9",2600.00);

        System.out.println(nico.getNome());
        System.out.println(nico.getBonificacao());
        
        assertTrue("O nome esta incorreto", "Nico Steppat".equals(nico.getNome()));
        assertEquals("Salario incorreto", 0, Double.compare(2600.0, nico.getSalario()));

	}
}
