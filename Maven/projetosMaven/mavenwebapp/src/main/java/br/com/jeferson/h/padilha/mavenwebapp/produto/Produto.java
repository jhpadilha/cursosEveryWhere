package br.com.jeferson.h.padilha.mavenwebapp.produto;

public class Produto {

    private final String nome;
    private final double preco;

    public Produto(String nome, double preco) {
        super();
        this.nome = nome;
        this.preco = preco;
    }

	public String getNome() {
		return this.nome;
	}
	
	public double getPreco() {
		return preco;
	}
}