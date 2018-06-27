package br.com.jeferson.h.padilha.bytebank;

public abstract class UsuarioAutenticavelImpl implements UsuarioAutenticavel{
	
	public boolean autenticaSenhaDesbloqueio(int senha) {
		boolean usuarioDesbloqueao = false;
		if (this.getSenhaDesbloqueio() == senha) {
			usuarioDesbloqueao = true;
		}
		
		return usuarioDesbloqueao;
	}
	
}
