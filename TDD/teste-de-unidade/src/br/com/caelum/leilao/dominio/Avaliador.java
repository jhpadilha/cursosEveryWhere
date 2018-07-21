package br.com.caelum.leilao.dominio;

public class Avaliador {
	
	private double maiorLance = Double.NEGATIVE_INFINITY;

	public void avalia(Leilao leilao) {
		for (Lance lance: leilao.getLances()) {
			if (lance.getValor() > maiorLance) {
				maiorLance = lance.getValor();
			}
		}
	}
	
	public double getMaiorLance() {
		return maiorLance;
	}
}
