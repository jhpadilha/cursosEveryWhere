package br.com.jeferson.h.padilha.bytebank;

public class Empregado extends Funcionario{

	private int tipoFuncionario; 
	private int senha;
	private double percentualBonificacao;
	
  //////////////////////////////////////////////////////////////
	// construtor
  //////////////////////////////////////////////////////////////
	
	public Empregado(String nome, String cpf, double salario) {
    super(nome, cpf, salario);
    
    tipoFuncionario = 0; 
    senha = 00000;
    percentualBonificacao = 0.10;
  }
	
	//////////////////////////////////////////////////////////////
	// Comportamentos ...
	//////////////////////////////////////////////////////////////
	
	
	
	// Getters ...

	
	public int getTipoFuncionario() {
		return tipoFuncionario;
	}
	
	public void setTipoFuncionario(int tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	
	@Override
	public int getSenha() {
		return this.senha;
	}
	
	@Override
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	@Override
	public double getPercentualBonificacao() {
		return this.percentualBonificacao ;
	}
	
	@Override
	public void setPercentualBonificacao(double percentualBonificacao) {
		this.percentualBonificacao = percentualBonificacao;
		
	}
}
