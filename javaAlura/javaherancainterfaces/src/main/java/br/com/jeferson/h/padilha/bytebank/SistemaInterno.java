package br.com.jeferson.h.padilha.bytebank;

public class SistemaInterno {
	private int senhaDesbloqueio = 55555;
	
	public boolean desbloqueiaAreaEspecialAcesso(UsuarioAutenticavel funcionarioAutenticavel) {
		boolean funcionarioPossuiSenhaDesbloqueio = funcionarioAutenticavel.autenticaSenhaDesbloqueio(senhaDesbloqueio);
		
		if (funcionarioPossuiSenhaDesbloqueio) {
			System.out.println("Usuario Posui senha de desbloqueio da area de acesso ! ");
		} else {
			System.out.println("Usuario não possui senha de desbloqueio da area de acesso ! ");
		}
		
		return funcionarioPossuiSenhaDesbloqueio;
	}
	

}
