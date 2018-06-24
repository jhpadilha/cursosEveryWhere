package br.com.jeferson.h.padilha.mailreceiver.connection;

public class GmailConector extends EmailConector {
	
	private static String HOST_ = "pop.gmail.com";
	private static String PORT_ = "995";
	private static String PROTOCOL_ = "pop3";
	
	private static String HOST = "imap.gmail.com";
	private static String PORT;
	private static String PROTOCOL = "imaps";
	

	@Override
	protected String getHost() {
		return HOST;
	}

	@Override
	protected String getPort() {
		return PORT;
	}

	@Override
	protected String getProtocol() {
		return PROTOCOL;
	}
}
