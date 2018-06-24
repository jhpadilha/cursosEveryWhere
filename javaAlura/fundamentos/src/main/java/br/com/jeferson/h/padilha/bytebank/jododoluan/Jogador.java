package br.com.jeferson.h.padilha.bytebank.jododoluan;

public class Jogador {
    private static int total = 0;
    
    private static void addCountContador() {
    	Jogador.total += 1;
    }

    public Jogador(){
       addCountContador();
    }
}
