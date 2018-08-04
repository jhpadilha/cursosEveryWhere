package br.com.alura.alurator.reflection;

import java.lang.reflect.Method;

import br.com.alura.alurator.protocolo.FullQualifiedUrlConstructorControllersControleEstoque;

public class Reflection {

	private FullQualifiedUrlConstructorControllersControleEstoque classFullQualifiedName = null;
	
	public Reflection(String url) {
		this.classFullQualifiedName = new FullQualifiedUrlConstructorControllersControleEstoque(url);
	}

	public ManipuladorClasse createControllerPorReflection() {
		String fullpath = classFullQualifiedName.getFullQualifiedClassName();
		
		try {
			Class<?> classe = Class.forName(fullpath);
			return new ManipuladorClasse(classe);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public ManipuladorObjeto criaInstancia() {
		ManipuladorClasse manipuladorClasse = this.createControllerPorReflection();
		
		
		
		Object objetoManipulado = manipuladorClasse
		.getConstrutorPadrao()
		.executaConstrutor();		
		
		return new ManipuladorObjeto(manipuladorClasse, objetoManipulado, classFullQualifiedName);
	}

}
