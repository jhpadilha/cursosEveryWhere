package br.com.jeferson.h.padilha.bytebank;

public class Empregado extends Funcionario{

	private int tipoFuncionario = 0; 
	private int senha = 00000;
	private double percentualBonificacao = 0.10;
	
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
