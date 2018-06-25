package br.com.jeferson.h.padilha.bytebank;

public class Gerente extends Funcionario{

	private int tipoFuncionario = 1; 
	private int senha = 11111;
	private double percentualBonificacao = 0.45;
	
    //////////////////////////////////////////////////////////////
	// construtor
    //////////////////////////////////////////////////////////////
	
	// Super ...
	
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
