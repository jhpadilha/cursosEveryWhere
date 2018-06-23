package br.com.jeferson.h.padilha.fundamentos;

public class TestaVariaveis {
	public static void main(String[] args) {
		System.out.println("ola novo teste !");
		
		int idade;
		
		idade = 33;
		System.out.println(idade);
		idade = 33 + 10;
		System.out.println(idade);
		idade = (30 * 5 ) + 2;
		System.out.println(idade);
		idade = 33;
		System.out.println(idade);
		idade = 33;
		System.out.println(idade);
		
		// utilizar nomes de variaveis bem descritivos, grandes
		int valorMaximoSalario = 100;
		
		// intring dapara concatenar com variaveis
		System.out.println("O salario maximo é : " + valorMaximoSalario);
		
		// double mais utilizado
		double salario = 45.5;
		
		System.out.println("meu salario é : " + salario);
		
		double piDividido = 3.14/ 2;
		System.out.println("Divisão do PI : " + piDividido);
		
		int truncaInt = 5/2;
		System.out.println("trunca divisao : " + truncaInt);
		
		double divisaoEntreIntsDaInt = 5/2;
		System.out.println("Divisão de int com int vai dar int : " + divisaoEntreIntsDaInt);
		
		double divisaoEntreIntDoubleDaDouble = 5.0 /2;
		System.out.println("Divisão entre double e int da double, sempre vale o maior tipo :" + divisaoEntreIntDoubleDaDouble);
		
		double doubleToCastInt = 5.5;
		int intFromDoubleCasteed = (int)doubleToCastInt;
		
		double valor1 = 0.2;
		double valor2 = 0.1;
		double total = valor1 + valor2;
		
		System.out.println("Convenção do 300000004 : " + total);
		
		
		/*
		[b]byte = 1 byte - 8 bits = -128-127 - números inteiros
		short = 2 bytes - 16 bits = -32768 a +32767 - números inteiros
		int = 4 bytes - 32 bits = -2147483648 a + 2147483647 - números inteiros
		long = 8 bytes - 64 bits = -922337203685477808 a 922337203685477807 - números inteiros
		float = 4 bytes - 32 bits = aproximadamente 3.40282347E+38 = Ponto flutuante
		double = 8bytes - 64 bits = 1.79769313486231570W+308 = Ponto Flutuante
		chart = Caracteres Unicode 16 bits = 0 a 65536 = caracteres
		booleann = Possuem valores True e false = booleano
		*/
	}
}
