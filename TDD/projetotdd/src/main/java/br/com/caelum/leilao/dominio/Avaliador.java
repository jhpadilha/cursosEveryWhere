package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
	
	private double maiorLance = Double.NEGATIVE_INFINITY;
	private double menorLance = Double.POSITIVE_INFINITY;
	private List<Lance> tresMaioresLances = new ArrayList<Lance>();
	
	public void avalia(Leilao leilao) {
		for (Lance lance: leilao.getLances()) {
			if (lance.getValor() > maiorLance) {
				maiorLance = lance.getValor();
			}// "else if" deu bug
			if (lance.getValor() < menorLance) {
				menorLance = lance.getValor();
			}
		}
		
		calculaTresMaioresLances(leilao);
	}
	
	private void calculaTresMaioresLances(Leilao leilao) {
		List<Lance> lancesOrdenadosValor = new ArrayList<Lance>(leilao.getLances());
		
		Collections.sort(lancesOrdenadosValor, new Comparator<Lance>() {
			public int compare(Lance o1, Lance o2) {
				if (o1.getValor() < o2.getValor()) return 1;
				if (o1.getValor() > o2.getValor()) return -1;
				return 0;
			}
		});
		
		int indiceLimite = lancesOrdenadosValor.size() > 3 ? 3 : lancesOrdenadosValor.size();
		tresMaioresLances = lancesOrdenadosValor.subList(0, indiceLimite);
//		if(lancesOrdenadosValor.size() < 3) {
//			tresMaioresLances =  lancesOrdenadosValor;
//		}else {
//			tresMaioresLances = lancesOrdenadosValor.subList(0, 3);
//		}
		
	}

	public double getMaiorLance() {
		if (maiorLance == Double.NEGATIVE_INFINITY) {
			return 0;
		}
		return maiorLance;
	}

	public double getMenorLance() {
		if(menorLance == Double.POSITIVE_INFINITY) {
			return 0;
		}
		return menorLance;
	}
	
	public double getMediaEntreMaiorMenorLance() {
		double total = getMaiorLance() + getMenorLance();
		
		if (total == 0) {
			return 0;
		}
		
		return total/2;
	}

	public List<Lance> getTresMaioresLances() {
		return tresMaioresLances;
	}
}

