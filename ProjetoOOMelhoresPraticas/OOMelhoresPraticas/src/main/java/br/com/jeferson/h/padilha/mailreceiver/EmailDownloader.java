package br.com.jeferson.h.padilha.mailreceiver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeUtility;

import br.com.jeferson.h.padilha.mailreceiver.connection.EmailConector;
import br.com.jeferson.h.padilha.mailreceiver.connection.GmailConector;

public class EmailDownloader {
	
	private String caminhoRaizParaDownloadEmails;
	private EmailConector emailConector;
	private EmailUser emailUser;
	
	private EmailDownloader() {
	}
	
	public EmailDownloader(String caminhoRaizParaDownloadEmails, EmailConector emailConector, EmailUser emailUser) {
		this.emailConector = emailConector;
		this.emailUser = emailUser;
		this.caminhoRaizParaDownloadEmails = caminhoRaizParaDownloadEmails;
	}
	
	public void iniciarDownload() throws Exception {
		try {
			preparaDiretorioParaDownload(caminhoRaizParaDownloadEmails);
			
			emailConector.loginUser(emailUser);
			
			List<String> pastas = emailConector.getPastas();
			
			for (String folder : pastas) {
				processarPastaCorreioEmail(folder);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro executando o download de emails !", e);
		} finally {
			emailConector.logout();
		};
	}

	private void processarPastaCorreioEmail(String folderName) throws MessagingException {
		String diretorioPasta = preparaDiretorioPasta(folderName);
		
		Folder folder = emailConector.abrePasta(folderName);
		
		Message[] arrayMessages = folder.getMessages();
		
		if (arrayMessages.length <=0) {
			return;
		}

		 for (int i = 0; i < arrayMessages.length; i++) {
		//for (int i = 0; i < 5; i++) {
			Message message = arrayMessages[i];
			
			new Email(message, diretorioPasta);
			
		}

		folder.close(false);
	}

	private String preparaDiretorioPasta(String folderName) {
		String diretorioPasta = caminhoRaizParaDownloadEmails + File.separator  + folderName;
		preparaDiretorioParaDownload(diretorioPasta);
		return diretorioPasta;
	}

	private void preparaDiretorioParaDownload(String caminhoRaizParaDownloadEmails) {
		File diretorioRaizParaDownloadEmails = new File(caminhoRaizParaDownloadEmails);
		if (!diretorioRaizParaDownloadEmails.exists()) {
			diretorioRaizParaDownloadEmails.mkdirs();
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			String text = "C:\\GmailDownload\\[Gmail]\\E-mails enviados\\279\\Captura de tela de 2012-12-26 11:22:38.png";
			System.out.println(MimeUtility.encodeText(text));
			File f1 = new File(removeReservedCharacters(text));
			f1.createNewFile();
			String text2 = "C:\\GmailDownload\\[Gmail]\\E-mails enviados\\352\\C:\\Users\\Jeferson\\Documents\\curriculum_jefersonpadilha.pdf";
			System.out.println(MimeUtility.encodeText(text2));
			File f2 = new File(removeReservedCharacters(text2));
			f2.createNewFile();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-gen//erated catch block
			e.printStackTrace();
		} 
		
//		Properties prop = new Properties();
//		InputStream input = null;
//		
//		String user;
//		String pass;
//
//		try {
//
//			String caminhoRaizParaDownloadEmails = "C:\\GmailDownload";
//			
//			GmailConector gmailConector = new GmailConector();
//			
//			input = new FileInputStream("C:\\GmailDownload\\GmailUserProperties.properties");
//			prop.load(input);
//
//			user = prop.getProperty("user");
//			pass = prop.getProperty("pass");
//			EmailUser emailUser = new EmailUser(user, pass); 
//			
//			EmailDownloader emailDownloader = new EmailDownloader(caminhoRaizParaDownloadEmails, gmailConector, emailUser);
//			emailDownloader.iniciarDownload();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	public static String removeReservedCharacters(String unFilledName) {
		
		String  fileName = unFilledName;
		
		if(fileName.contains("\\")) {
			String[] split = fileName.split("\\\\");
			fileName = split[split.length-1];
		}
		
		if(fileName.contains("/")) {
			String[] split2 = fileName.split("\\/");
			fileName = split2[split2.length-1];
		}
		
		System.out.println(fileName);
		
		
		fileName = fileName.replace("<", "_");
		fileName = fileName.replace(">", "_");
		fileName = fileName.replace(":", "_");
		fileName = fileName.replace("\"", "_");
		fileName = fileName.replace("\\", "_");
		fileName = fileName.replace("/", "_");
		fileName = fileName.replace("|", "_");
		fileName = fileName.replace("?", "_");
		fileName = fileName.replace("*", "_");
		fileName = fileName.replace("&", "_");
		fileName = fileName.replace("%", "_");
		fileName = fileName.replace("$", "_");
		fileName = fileName.replace("#", "_");
		fileName = fileName.replace("@", "_");
		fileName = fileName.replace("!", "_");
		fileName = fileName.replace("(", "_");
		fileName = fileName.replace(")", "_");
		fileName = fileName.replace("-", "_");
		fileName = fileName.replace("+", "_");
		fileName = fileName.replace("=", "_");
		fileName = fileName.replace("§", "_");
		fileName = fileName.replace("^", "_");
		fileName = fileName.replace("{", "_");
		fileName = fileName.replace("[", "_");
		fileName = fileName.replace("]", "_");
		fileName = fileName.replace("}", "_");
		fileName = fileName.replace("?", "_");
		fileName = fileName.replace(" ", "_");
		System.out.println(fileName);
		return fileName;
	}
}
