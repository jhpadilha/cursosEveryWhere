package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AvaliadorTeste {

	@Test
	public void entenderLancesOrdemMisturadaTest() {

		// cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("PLaystation 4");

		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(jose, 400));
		leilao.propoe(new Lance(maria, 250));

		// execucao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// validacao
		int menorEsperado = 250;
		int maiorEsperado = 400;
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0);
	}

	@Test
	public void entenderLancesOrdemCrescenteTest() {
		
		//cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("PLaystation 4");

		leilao.propoe(new Lance(joao, 250));
		leilao.propoe(new Lance(jose, 300));
		leilao.propoe(new Lance(maria, 400));

		//execucao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// validacao
		int menorEsperado = 250;
		int maiorEsperado = 400;
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0);
	}

	@Test
	public void mediaEntreMaiorMenorLanceOrdemCrescenteTest() {
		
		//cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("PLaystation 4");

		leilao.propoe(new Lance(joao, 250));
		leilao.propoe(new Lance(jose, 300));
		leilao.propoe(new Lance(maria, 400));

		//execucao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// validacao
		double mediaEsperada = 325;
		assertEquals(mediaEsperada, leiloeiro.getMediaEntreMaiorMenorLance(), 0);
	}	
	
	@Test
	public void mediaEntreMaiorMenorLanceDesordenadoTest() {
		
		//cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("PLaystation 4");

		leilao.propoe(new Lance(joao, 400));
		leilao.propoe(new Lance(jose, 250));
		leilao.propoe(new Lance(maria, 300));

		//execucao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// validacao
		double mediaEsperada = 325;
		assertEquals(mediaEsperada, leiloeiro.getMediaEntreMaiorMenorLance(), 0);
	}	
	
	@Test
	public void apenasUmLanceTest() {
		
		//cenario
		Usuario joao = new Usuario("Joao");
		Leilao leilao = new Leilao("PLaystation 4");

		leilao.propoe(new Lance(joao, 200));

		//execucao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// validacao
		int menorEsperado = 200;
		int maiorEsperado = 200;
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0);
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0);
	}	
	
	@Test
	public void retornaTresMaioresLancesTest() {
		
		//cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("PLaystation 4");

		leilao.propoe(new Lance(joao, 400));
		leilao.propoe(new Lance(jose, 250));
		leilao.propoe(new Lance(maria, 300));
		
		leilao.propoe(new Lance(joao, 800));
		leilao.propoe(new Lance(jose, 550));
		leilao.propoe(new Lance(maria, 700));

		//execucao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// validacao
		List<Lance> tresMaioresLances = leiloeiro.getTresMaioresLances();
		Lance primeiroMaiorLance = tresMaioresLances.get(0);
		Lance segundoMaiorLance  = tresMaioresLances.get(1);
		Lance terceiroMaiorLance  = tresMaioresLances.get(2);
		
		int valorPrimeiroMaiorLance = 800;
		int valorSegundoMaiorLance  = 700;
		int valorTerceiroMaiorLance  = 550;
		
		assertEquals(valorPrimeiroMaiorLance, primeiroMaiorLance.getValor(), 0);
		assertEquals(valorSegundoMaiorLance, segundoMaiorLance.getValor(), 0);
		assertEquals(valorTerceiroMaiorLance, terceiroMaiorLance.getValor(), 0);
	}	
	
	@Test
    public void deveEntenderLeilaoComLancesEmOrdemRandomica() {
        Usuario joao = new Usuario("Joao"); 
        Usuario maria = new Usuario("Maria"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao,200.0));
        leilao.propoe(new Lance(maria,450.0));
        leilao.propoe(new Lance(joao,120.0));
        leilao.propoe(new Lance(maria,700.0));
        leilao.propoe(new Lance(joao,630.0));
        leilao.propoe(new Lance(maria,230.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
    }
	
	@Test
    public void deveEntenderLeilaoComLancesEmOrdemDecrescente() {
        Usuario joao = new Usuario("Joao"); 
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao ,400.0));
        leilao.propoe(new Lance(maria,300.0));
        leilao.propoe(new Lance(joao ,200.0));
        leilao.propoe(new Lance(maria,100.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(100.0, leiloeiro.getMenorLance(), 0.0001);
    }
	
	@Test
    public void deveEntenderLeilaoComDoisLances() {
        Usuario joao = new Usuario("Joao"); 
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao ,400.0));
        leilao.propoe(new Lance(maria,300.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(300.0, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(350, leiloeiro.getMediaEntreMaiorMenorLance(), 0.0001);
        assertEquals(2, leiloeiro.getTresMaioresLances().size(), 0.0001);
    }
	
	@Test
    public void deveEntenderLeilaoComNenhumLances() {
        Usuario joao = new Usuario("Joao"); 
        Usuario maria = new Usuario("Maria");
        
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(0.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(0.0, leiloeiro.getMenorLance(), 0.0001);
        assertEquals(0, leiloeiro.getMediaEntreMaiorMenorLance(), 0.0001);
        assertEquals(0, leiloeiro.getTresMaioresLances().size(), 0.0001);
    }
}
