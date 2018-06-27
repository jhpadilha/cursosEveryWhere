package br.com.jeferson.h.padilha.bytecompany;

import br.com.jeferson.h.padilha.bytecompany.autenticacao.Autenticavel;
import br.com.jeferson.h.padilha.bytecompany.autenticacao.Autenticador;

public class Diretor extends Funcionario implements Autenticavel{

	private int tipoFuncionario; 
	private double percentualBonificacao;
	private Autenticador autenticador;
	
    //////////////////////////////////////////////////////////////
	// construtor
    //////////////////////////////////////////////////////////////
	
	public Diretor(String nome, String cpf, double salario) {
    super(nome, cpf, salario);
    
    tipoFuncionario = 2; 
    percentualBonificacao = 0.75;
    autenticador = new Autenticador();
  }
	
	//////////////////////////////////////////////////////////////
	// Comportamentos ...
	//////////////////////////////////////////////////////////////
	
	public boolean autenticaSenhaDesbloqueio(int senha) {
    return this.autenticador.autenticaSenhaDesbloqueio(senha);
  }
	
	// Getters ...

	
	public int getTipoFuncionario() {
		return tipoFuncionario;
	}
	
	public void setTipoFuncionario(int tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
	
	public int getSenhaDesbloqueio() {
		return this.autenticador.getSenhaDesbloqueio();
	}
	
	public void setSenhaDesbloqueio(int senhaDesbloqueio) {
	  autenticador.setSenhaDesbloqueio(senhaDesbloqueio);
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
