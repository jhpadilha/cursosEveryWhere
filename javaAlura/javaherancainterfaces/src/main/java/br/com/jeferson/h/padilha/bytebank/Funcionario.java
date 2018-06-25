package br.com.jeferson.h.padilha.bytebank;

public class Funcionario {

	private String nome;
	private String cpf;
	private double salario;
	private int tipoFuncionario = 0; // 0 - Comun // 1 - Gerente // 2 - Diretor
	
	// construtor
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, String cpf, double salario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}
	
	// Comportamentos ...

	public double getBonificacao() {
		double retorno = 0;
		if (tipoFuncionario == 0) {
			retorno = this.salario * 0.10;			
		}else if (tipoFuncionario == 1) {
			retorno = this.salario * 0.45;
		}else if (tipoFuncionario == 2) {
			retorno = this.salario * 0.75;
		}
		return retorno;
	}
	
	// Getters ...
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public int getTipoFuncionario() {
		return tipoFuncionario;
	}
	
	public void setTipoFuncionario(int tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	
}
