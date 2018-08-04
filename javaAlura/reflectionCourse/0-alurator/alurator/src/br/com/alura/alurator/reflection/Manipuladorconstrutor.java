package br.com.alura.alurator.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Manipuladorconstrutor {

	private Constructor<?> construtor;

	public Manipuladorconstrutor(Constructor<?> construtor) {
		this.construtor = construtor;
		// TODO Auto-generated constructor stub
	}

	public Object executaConstrutor() {
		try {
			return this.construtor.newInstance(null);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}
