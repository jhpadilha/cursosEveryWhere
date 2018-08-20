package br.com.alura.alurator.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipuladorMetodo {

	private Object objetoManipulado;
	private Method declaredMethod;
	private String[] parametros;

	public ManipuladorMetodo(Object objetoManipulado, Method declaredMethod, String ... parametros) {
		this.objetoManipulado = objetoManipulado;
		this.declaredMethod = declaredMethod;
		this.parametros = parametros;
	}
	
	public Object invoca() {
		
		try {
			Object invoke = declaredMethod.invoke(objetoManipulado,parametros);
			return invoke;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
