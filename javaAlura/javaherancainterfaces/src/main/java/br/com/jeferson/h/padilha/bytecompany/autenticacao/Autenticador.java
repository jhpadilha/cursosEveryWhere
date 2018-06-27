package br.com.jeferson.h.padilha.bytecompany.autenticacao;

public class Autenticador implements Autenticavel{
  
  private int senhaDesbloqueio;

  public Autenticador() {
  }
  
  public Autenticador(int senhaDesbloqueio) {
    this.setSenhaDesbloqueio(senhaDesbloqueio);
  }
	
	public boolean autenticaSenhaDesbloqueio(int senha) {
		boolean usuarioDesbloqueao = false;
		if (this.getSenhaDesbloqueio() == senha) {
			usuarioDesbloqueao = true;
		}
		
		return usuarioDesbloqueao;
	}

  public int getSenhaDesbloqueio() {
    return senhaDesbloqueio;
  }

  public void setSenhaDesbloqueio(int senhaDesbloqueio) {
    this.senhaDesbloqueio = senhaDesbloqueio;
  }
	
}
