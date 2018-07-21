package mavenwebapp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.jeferson.h.padilha.mavenwebapp.produto.Produto;

public class ProdutoTest {
	
	@Test
	public void testName() {
		Produto produto = new Produto("teste", .1);
		assertEquals("O valor que esta sendo retornado está errado.", .1, produto.getPreco(),0);
	}

}
