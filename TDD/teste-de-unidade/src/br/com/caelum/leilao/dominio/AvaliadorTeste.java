package br.com.caelum.leilao.dominio;

import org.junit.Test;

public class AvaliadorTeste {

	@Test
	public void maiorLanceTest() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("PLaystation 4");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(jose, 400));
		leilao.propoe(new Lance(maria, 250));
		
		Avaliador leiloeiro = new Avaliador();
		
		leiloeiro.avalia(leilao);
		
		Assert.
	}
}
