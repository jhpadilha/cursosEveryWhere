package br.com.jeferson.h.padilha.bytebank;

public interface UsuarioAutenticavel{
	
//	public UsuarioAutenticavel(String nome, String cpf, double salario) {
//		super(nome, cpf, salario);
//	}

//	public boolean autenticaSenhaDesbloqueio(int senha) {
//		boolean usuarioDesbloqueao = false;
//		if (this.getSenhaDesbloqueio() == senha) {
//			usuarioDesbloqueao = true;
//		}
//		
//		return usuarioDesbloqueao;
//	}
	
	public boolean autenticaSenhaDesbloqueio(int senha);
	public int getSenhaDesbloqueio();
	public void setSenhaDesbloqueio(int senha);
}
