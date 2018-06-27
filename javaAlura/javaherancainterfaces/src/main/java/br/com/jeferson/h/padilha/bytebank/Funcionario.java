package br.com.jeferson.h.padilha.bytebank;

public abstract class Funcionario{

	private String nome;
	private String cpf;
	private double salario;
	private int tipoFuncionario = 0; 

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
		return this.getSalario() * getPercentualBonificacao();
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
	
	// 0 - empregado (0.10) // 1 - Gerente(.45) // 2 - Diretor
	public abstract int getTipoFuncionario();	
	public abstract void setTipoFuncionario(int tipoFuncionario);
	public abstract double getPercentualBonificacao();
	public abstract void setPercentualBonificacao(double percentualBonificacao);
	
	
}
