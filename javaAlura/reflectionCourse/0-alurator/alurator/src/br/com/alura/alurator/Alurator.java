package br.com.alura.alurator;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.reflection.Reflection;

public class Alurator {

	public Alurator() {
	}

	public Object executa(String url) throws IllegalArgumentException, InvocationTargetException {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao

		
		
		/*
		Modo Procedural
		try {
			String fullQualifiedClassName = new FullQualifiedUrlConstructorControllersControleEstoque(url).getFullQualifiedClassName();
			Class<?> classeControle = Class.forName(fullQualifiedClassName);
			// Object instanciaControle = classeControle.newInstance();
			Constructor<?> construtor = classeControle.getConstructor(null);
			Object instanciaControle = construtor.newInstance(null);

			System.out.println(instanciaControle);


		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException e) {
			throw new RuntimeException(e);
		}*/
		
		
		/*Object objectDeControler = new Reflection(url)
		.createControllerPorReflection()
		.getConstrutorPadrao()
		.executaConstrutor();*/
		
		
		Object retorno = new Reflection(url)
				.criaInstancia()
				.getMetodo()
				.invoca();
		
		
		return retorno;
	}
}
