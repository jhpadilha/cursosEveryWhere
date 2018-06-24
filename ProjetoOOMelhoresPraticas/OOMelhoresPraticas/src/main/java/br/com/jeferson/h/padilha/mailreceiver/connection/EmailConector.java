package br.com.jeferson.h.padilha.mailreceiver.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import br.com.jeferson.h.padilha.mailreceiver.EmailUser;

public abstract class EmailConector {
	
	private Properties properties;
	private Session session;
	private Store store;
	private boolean logado;
	
	public EmailConector() {
		initialize();
		
		setupProperties();
		
		generateSession();
	}

	private void initialize() {
		logado = false;
	}

	private void setupProperties() {
		this.properties = new Properties();
//		properties.put("mail.pop3.host", getHost());
//		properties.put("mail.pop3.port", getPort());
//
//		// SSL setting
//		properties.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		properties.setProperty("mail.pop3.socketFactory.fallback", "false");
//		properties.setProperty("mail.pop3.socketFactory.port", String.valueOf(getPort()));
		properties.setProperty("mail.store.protocol", getProtocol());
	}
	
	private void generateSession() {
		session = Session.getDefaultInstance(properties);
	}
	
	public void loginUser(EmailUser user) throws MessagingException {
		this.store = session.getStore(getProtocol());
		this.store.connect(getHost(), user.getUserName(), user.getPassword());
		logado = true;
	}
	
	public void logout() throws MessagingException {
		if (this.store != null && this.store.isConnected()) {
			this.store.close();
		}
	}
	
	public List<String> getPastas() throws Exception {
		
		List<String> listaPastas = new ArrayList<String>();
		
//		listaPastas.add("INBOX"); 
//		//listaPastas.add("imp"); 
//		listaPastas.add("imp"); 
//		listaPastas.add("sent"); 
//		listaPastas.add("chats"); 
//		listaPastas.add("drafts"); 
//		listaPastas.add("spam"); 
//		listaPastas.add("trash"); 
		//listaPastas.add("all"); 
		//listaPastas.add("");
		
		Folder[] folders = store.getDefaultFolder().list("*");
	    for (javax.mail.Folder folder : folders) {
	        if ((folder.getType() & javax.mail.Folder.HOLDS_MESSAGES) != 0) {
	            //System.out.println(folder.getFullName() + ": " + folder.getMessageCount());
	        	listaPastas.add(folder.getFullName());
	        }
	    }
		
		return listaPastas;
		//return folders.values().stream().collect(Collectors.toList());
	}
	
	private void validaUsuarioEstaLogado() throws Exception {
		if (! logado) {
			throw new Exception("O Uruário deve estar logado !");
 		}
		
	}

	protected abstract String getHost();
	protected abstract String getPort();
	protected abstract String getProtocol();

	public Folder abrePasta(String folderName) throws MessagingException {
		Folder folder = this.store.getFolder(folderName);
		folder.open(Folder.READ_ONLY);
		
		return folder;
	}
}
