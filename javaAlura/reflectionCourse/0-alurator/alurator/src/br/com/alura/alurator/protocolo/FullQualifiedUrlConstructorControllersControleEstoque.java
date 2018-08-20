package br.com.alura.alurator.protocolo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullQualifiedUrlConstructorControllersControleEstoque {

	private static String PACOTEBASE = "br.com.alura.estoque.controle";
	private String url;
	private String nomeControle;
	private String nomeMetodoControle;
	private List<String> parametrosMetodoControle = new ArrayList<>();

	public FullQualifiedUrlConstructorControllersControleEstoque(String url) {
		this.url = url;
		
		String subPaths[] = url.replaceFirst("/", "").split("/");

		nomeControle = Character.toUpperCase(subPaths[0].charAt(0)) + subPaths[0].substring(1) + "Controller";
		nomeMetodoControle = subPaths[1];
		if (subPaths.length > 2) {
			parametrosMetodoControle =Arrays.asList(subPaths).subList(2,subPaths.length);
		}
		
	}
	
	public String getFullQualifiedClassName() {
		return PACOTEBASE + "." + nomeControle;
	}
	
	public String getNomeMetodoControle() {
		return nomeMetodoControle;
	}
	
	public List<String> getParametrosMetodoControle() {
		return this.parametrosMetodoControle;
	}
	
	public String[] getArrayparametrosMetodo() {
		return parametrosMetodoControle == null || parametrosMetodoControle.isEmpty() ? null : parametrosMetodoControle.toArray(new String[parametrosMetodoControle.size()]);
	}
	
	public Class<?>[] getArrayClassesParametrosMetodo() {
		ArrayList<Class> listaclasses = null;
		if(parametrosMetodoControle != null && !parametrosMetodoControle.isEmpty()) {
			listaclasses = new ArrayList<>();
			for (int i = 0 ; i < parametrosMetodoControle.size(); i++) {
				listaclasses.add(String.class);
			}
		}
		return listaclasses == null || listaclasses.isEmpty() ? null : listaclasses.toArray(new Class<?>[listaclasses.size()]);
	}
}
