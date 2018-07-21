package br.com.caelum.leilao.dominio;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class FiltroDeLancesTest {
	
	// 500  >-->>  <<--< 700
    // 1000 >-->>  <<--< 3000
    // 5000 >-->> ...
	@Test
    public void deveSelecionarLancesEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 1000), //Nok
                new Lance(joao, 2000), //ok
                new Lance(joao, 3000), //Nok
                new Lance(joao,  800), //Nok
                new Lance(joao, 1001), //ok
                new Lance(joao, 4000), //Nok
                new Lance(joao,  999), //Nok
                new Lance(joao, 2999), //ok
                new Lance(joao, 3001)  //Nok
                ));

        assertEquals(3, resultado.size());
        assertEquals(2000, resultado.get(0).getValor(), 0.00001);
        assertEquals(1001, resultado.get(1).getValor(), 0.00001);
        assertEquals(2999, resultado.get(2).getValor(), 0.00001);
    }

	// 500  >-->>  <<--< 700
    @Test
    public void deveSelecionarLancesEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
        		new Lance(joao,400), //nok
        		new Lance(joao,699), //ok
        		new Lance(joao,499), //nok
        		new Lance(joao,500), //nok
        		new Lance(joao,501), //ok
                new Lance(joao,700), //nok
                new Lance(joao,701), //nok
                new Lance(joao,600), //ok
                new Lance(joao, 800) //nok
                ));

        assertEquals(3, resultado.size());
        assertEquals(699, resultado.get(0).getValor(), 0.00001);
        assertEquals(501, resultado.get(1).getValor(), 0.00001);
        assertEquals(600, resultado.get(2).getValor(), 0.00001);
    }

 // 5000  >-->>  
    @Test
    public void deveSelecionarLancesMaiores5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
        		new Lance(joao,3999), //nok
        		new Lance(joao,5001), //ok
        		new Lance(joao,4000), //nok
        		new Lance(joao,5002), //ok
        		new Lance(joao,4999), //nok
        		new Lance(joao,5003),  //ok
        		new Lance(joao,5000) //nok
                ));

        assertEquals(3, resultado.size());
        assertEquals(5001, resultado.get(0).getValor(), 0.00001);
        assertEquals(5002, resultado.get(1).getValor(), 0.00001);
        assertEquals(5003, resultado.get(2).getValor(), 0.00001);
    }
    
    //--
    
    @Test
    public void deveSelecionarLanceMinEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 1000), //Nok
                new Lance(joao, 3000), //Nok
                new Lance(joao,  800), //Nok
                new Lance(joao, 1001), //ok
                new Lance(joao, 4000), //Nok
                new Lance(joao,  999), //Nok
                new Lance(joao, 3001)  //Nok
                ));

        assertEquals(1, resultado.size());
        assertEquals(1001, resultado.get(0).getValor(), 0.00001);
    }
    
    @Test
    public void deveSelecionarLanceMaxEntre1000E3000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
                new Lance(joao, 1000), //Nok
                new Lance(joao, 3000), //Nok
                new Lance(joao,  800), //Nok
                new Lance(joao, 2999), //ok
                new Lance(joao, 4000), //Nok
                new Lance(joao,  999), //Nok
                new Lance(joao, 3001)  //Nok
                ));

        assertEquals(1, resultado.size());
        assertEquals(2999, resultado.get(0).getValor(), 0.00001);
    }

	// 500  >-->>  <<--< 700
    @Test
    public void deveSelecionarLanceMinEntre500E700() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
        		new Lance(joao,400), //nok
        		new Lance(joao,499), //nok
        		new Lance(joao,500), //nok
        		new Lance(joao,501), //ok
                new Lance(joao,700), //nok
                new Lance(joao,701), //nok
                new Lance(joao, 800) //nok
                ));

        assertEquals(1, resultado.size());
        assertEquals(501, resultado.get(0).getValor(), 0.00001);
    }
    
    @Test
    public void deveSelecionarLanceMaxEntre500E700() {
    	Usuario joao = new Usuario("Joao");
    	
    	FiltroDeLances filtro = new FiltroDeLances();
    	List<Lance> resultado = filtro.filtra(Arrays.asList(
    			new Lance(joao,400), //nok
    			new Lance(joao,699), //ok
    			new Lance(joao,499), //nok
    			new Lance(joao,500), //nok
    			new Lance(joao,700), //nok
    			new Lance(joao,701), //nok
    			new Lance(joao, 800) //nok
    			));
    	
    	assertEquals(1, resultado.size());
    	assertEquals(699, resultado.get(0).getValor(), 0.00001);
    }

 // 5000  >-->>  
    @Test
    public void deveSelecionarLanceMaiores5000() {
        Usuario joao = new Usuario("Joao");

        FiltroDeLances filtro = new FiltroDeLances();
        List<Lance> resultado = filtro.filtra(Arrays.asList(
        		new Lance(joao,3999), //nok
        		new Lance(joao,5001), //ok
        		new Lance(joao,4000), //nok
        		new Lance(joao,4999), //nok
        		new Lance(joao,5000) //nok
                ));

        assertEquals(1, resultado.size());
        assertEquals(5001, resultado.get(0).getValor(), 0.00001);
    }
}
