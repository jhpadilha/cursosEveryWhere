package br.com.jeferson.h.padilha.mavenwebapp.produto;

public class AppProduto {
	
	public static void main(String[] args) {
		Produto produto = new Produto("BalaXYZ", 10);
		
		System.out.println("Minha bala preferida : " + produto.getNome());
		System.out.println("Que custa : " + produto.getPreco());
	}

}
