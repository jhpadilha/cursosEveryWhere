package br.com.jeferson.h.padilha.bytecompany.autenticacao;

public interface Autenticavel{
	public boolean autenticaSenhaDesbloqueio(int senha);
	
	abstract int getSenhaDesbloqueio() ;
  abstract void setSenhaDesbloqueio(int senhaDesbloqueio) ;
}
