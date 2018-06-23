package br.com.jeferson.h.padilha.mailreceiver;

public class EmailUser {
	
	private String userName; 
	private String password;
	
	public EmailUser(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

}
