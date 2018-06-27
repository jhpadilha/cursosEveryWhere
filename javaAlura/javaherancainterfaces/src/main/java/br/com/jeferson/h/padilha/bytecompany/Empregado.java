package br.com.jeferson.h.padilha.bytecompany;

public class Empregado extends Funcionario{

	private int tipoFuncionario; 
	private double percentualBonificacao;
	
  //////////////////////////////////////////////////////////////
	// construtor
  //////////////////////////////////////////////////////////////
	
	public Empregado(String nome, String cpf, double salario) {
    super(nome, cpf, salario);
    
    tipoFuncionario = 0; 
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
	public double getPercentualBonificacao() {
		return this.percentualBonificacao ;
	}
	
	@Override
	public void setPercentualBonificacao(double percentualBonificacao) {
		this.percentualBonificacao = percentualBonificacao;
		
	}
}
