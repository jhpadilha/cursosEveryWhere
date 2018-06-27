package br.com.jeferson.h.padilha.bytebank;

public class Diretor extends Funcionario implements UsuarioAutenticavel{

	private int tipoFuncionario; 
	private int senha;
	private double percentualBonificacao;
	
    //////////////////////////////////////////////////////////////
	// construtor
    //////////////////////////////////////////////////////////////
	
	public Diretor(String nome, String cpf, double salario) {
    super(nome, cpf, salario);
    
    tipoFuncionario = 2; 
    senha = 22222;
    percentualBonificacao = 0.75;
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
	
	public int getSenhaDesbloqueio() {
		return this.senha;
	}
	
	public void setSenhaDesbloqueio(int senha) {
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
