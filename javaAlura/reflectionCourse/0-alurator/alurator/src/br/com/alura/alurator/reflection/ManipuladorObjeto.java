package br.com.alura.alurator.reflection;

import java.lang.reflect.Method;
import java.util.List;

import br.com.alura.alurator.protocolo.FullQualifiedUrlConstructorControllersControleEstoque;

public class ManipuladorObjeto {

	private ManipuladorClasse manipuladorClasse;
	private Object objetoManipulado;
	private FullQualifiedUrlConstructorControllersControleEstoque classFullQualifiedName;
	private Method declaredMethod = null;

	public ManipuladorObjeto(ManipuladorClasse manipuladorClasse, Object objetoManipulado,
			FullQualifiedUrlConstructorControllersControleEstoque classFullQualifiedName) {
		this.manipuladorClasse = manipuladorClasse;
		this.objetoManipulado = objetoManipulado;
		this.classFullQualifiedName = classFullQualifiedName;

		

		try {
			String methodName = classFullQualifiedName.getNomeMetodoControle();
			declaredMethod = manipuladorClasse.getClasse().getDeclaredMethod(methodName, classFullQualifiedName.getArrayClassesParametrosMetodo());
			declaredMethod.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ManipuladorMetodo getMetodo() {
		return new ManipuladorMetodo(objetoManipulado, declaredMethod, classFullQualifiedName.getArrayparametrosMetodo());
		//   /produto/lista
		//   /produto/filtra/Produto 1
	}
	

}
