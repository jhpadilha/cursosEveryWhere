package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.alura.alurator.playground.controle.Controle;
import br.com.alura.alurator.playground.controle.SubControle;

public class TestaInstanceObject {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//trabalhandoComConstrutores();
		///////////////////////////////////////////////////////////////////////////////////////
		trabalhandoComMetodos();
	}

	private static void trabalhandoComMetodos() {
		try {
			Class<?> classeSubControle = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
			Constructor<?> constructor = classeSubControle.getDeclaredConstructor();
			constructor.setAccessible(true);
			Object newInstanceObject = constructor.newInstance();
			
			for(Method m : classeSubControle.getMethods() ) {
				System.out.println(m);
			}
			
			Method metodoPublico = classeSubControle.getMethod("metodoSubControle1");
			
			Method metodoPrivado = classeSubControle.getDeclaredMethod("metodoSubControle2");
			metodoPrivado.setAccessible(true);
			
			Object retornoMetodoPublico = metodoPublico.invoke(newInstanceObject);
			Object retornoMetodoPrivado = metodoPrivado.invoke(newInstanceObject);
			
			System.out.println(retornoMetodoPublico);
			System.out.println(retornoMetodoPrivado);
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void trabalhandoComConstrutores() throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class<Controle> classViral = Controle.class;

		Controle controleClassFromNew = new Controle();
		Class<? extends Controle> classControleFromNew = controleClassFromNew.getClass();

		Class<?> classPorNome = Class.forName("br.com.alura.alurator.playground.controle.Controle");

		// ---------------------------------------------------------------------------------------
		
		Controle controleObjectFromViral = classViral.newInstance();
		Controle controleObjectFromGetClass = classControleFromNew.newInstance();
		Controle controleObjectFromPorNome = (Controle) classPorNome.newInstance();
		
		System.out.println(controleObjectFromViral instanceof Controle);
		System.out.println(controleObjectFromGetClass instanceof Controle);
		System.out.println(controleObjectFromPorNome instanceof Controle);
		
		Class<SubControle> classSubControle = SubControle.class;
		
		// getDeclaredConstructor(Class<?> ...tiposArgs) da classe Class<T>. para privados e publicos
		// getConstructor(Class<?> ...tiposArgs) da classe Class<T>. somente para publicos
		// 
		// getDeclaredConstructor() da classe Class<T>. para privados e publicos
		// getConstructor() da classe Class<T>. somente para publicos
		// 
		
		Constructor<SubControle> construtorPrivadoSubControle = classSubControle.getDeclaredConstructor(null);
		construtorPrivadoSubControle.setAccessible(true);
		
		Constructor<SubControle> construtorPublicoSubControle = classSubControle.getConstructor(String.class);
		
		construtorPrivadoSubControle.newInstance(null);
		construtorPublicoSubControle.newInstance("");
	}
}
