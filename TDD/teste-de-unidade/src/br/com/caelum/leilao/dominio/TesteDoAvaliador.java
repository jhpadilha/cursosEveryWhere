package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteDoAvaliador {
  
  @Test
  public void teste1() {
    Usuario joao = new Usuario("Joao");
    Usuario jose = new Usuario("José");
    Usuario maria = new Usuario("Maria");

    Leilao leilao = new Leilao("Playstation 3 Novo");

    leilao.propoe(new Lance(joao,300.0));
    leilao.propoe(new Lance(jose,400.0));
    leilao.propoe(new Lance(maria,250.0));

    Avaliador leiloeiro = new Avaliador();
    leiloeiro.avalia(leilao);

    assertEquals(leiloeiro.getMaiorLance(), 400.0, 0);
    
  }

}
