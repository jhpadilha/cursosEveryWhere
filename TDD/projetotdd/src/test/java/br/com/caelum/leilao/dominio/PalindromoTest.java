package br.com.caelum.leilao.dominio;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import br.com.caelum.palindromo.dominio.Palindromo;

public class PalindromoTest {

	@Test
	public void testaPalindromoDeMarrocos() {
		String frasePalindroma = "Socorram-me subi no onibus em Marrocos";
		
		Palindromo palindromo = new Palindromo();
		boolean ehPalindromo = palindromo.ehPalindromo(frasePalindroma);
		
		System.out.println(ehPalindromo);
		assertThat(ehPalindromo, is(true));
	}

	@Test
	public void testaPalindromoDaMaratona() {
		String frasePalindroma = "Anotaram a data da maratona";
		
		Palindromo palindromo = new Palindromo();
		boolean ehPalindromo = palindromo.ehPalindromo(frasePalindroma);
		
		System.out.println(ehPalindromo);
		assertThat(ehPalindromo, is(true));
		assertTrue(ehPalindromo);
	}

	@Test
	public void deveIdentificarSeNaoEhPalindromo() {
		Palindromo p = new Palindromo();

		boolean resultado = p.ehPalindromo("E preciso amar as pessoas como se nao houvesse amanha");
		
		assertFalse(resultado);
	}
}
