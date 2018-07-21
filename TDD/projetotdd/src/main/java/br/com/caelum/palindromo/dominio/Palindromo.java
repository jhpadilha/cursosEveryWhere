package br.com.caelum.palindromo.dominio;

public class Palindromo {

	public boolean ehPalindromo(String frase) {

		String fraseFiltrada = frase.toUpperCase().replace(" ", "").replace("-", "");

		for (int indiceVai = 0; indiceVai < fraseFiltrada.length(); indiceVai++) {
			int indiceVem = fraseFiltrada.length() - (indiceVai + 1);
			
			char charDaEsquerdaParaDireita = fraseFiltrada.charAt(indiceVai);
			char charDaDireitaParaEsquerda = fraseFiltrada.charAt(indiceVem);

			if (charDaEsquerdaParaDireita != charDaDireitaParaEsquerda) {
				return false;
			}
		}
		return true;
	}
}
