package br.com.alura.alurator.reflection;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

	private Class<?> classe;

	public ManipuladorClasse(Class<?> classe) {
		this.classe = classe;
	}

	public Manipuladorconstrutor getConstrutorPadrao() {
		try {
			Constructor<?> cons = classe.getDeclaredConstructor();
			return new Manipuladorconstrutor(cons);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Class<?> getClasse() {
		return classe;
	}

}
