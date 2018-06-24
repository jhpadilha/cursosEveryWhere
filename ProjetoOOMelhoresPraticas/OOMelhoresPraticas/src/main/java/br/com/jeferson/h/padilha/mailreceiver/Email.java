package br.com.jeferson.h.padilha.mailreceiver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("unused")
public class Email {
	
	private static Logger log = Logger.getLogger(Email.class); 
	
	private Map<String, String> listaHeaders;
	private List<String> listaDestinatarios;
	private List<String> listaEnviadores;
	private List<String> listaResposta;
	private List<String> listaFlags;
	private int indiceListaPasta;
	private String assunto;
	private String dataRecebimento;
	private String dataEnvio;
	private String nomePasta;
	private String tipoConteudoEmail;
	
	private String descricao;
	private String disposicao;
	private String nomeArquivoEmail;
	private InputStream arrayEntrada;
	private int numeroLinhas;
	private int tamanho;
	private String pastaGravacaoEmail;
	private ConteudoEmail conteudoEmail;
	private boolean ocorreuErroDuranteGeracaoEmail = false;
	
	public Email(Message message, String saveDirectory) {
		try {
			
			this.listaHeaders = convertHeadersToHashMap(message.getAllHeaders());
			this.listaDestinatarios = convertArrayAdressToListEmails(message.getAllRecipients());
			this.listaEnviadores = convertArrayAdressToListEmails(message.getFrom());
			this.listaResposta = convertArrayAdressToListEmails(message.getReplyTo());
			this.listaFlags = convertFlagsToList(message.getFlags());
			this.indiceListaPasta = message.getMessageNumber();
			this.assunto = message.getSubject();
			this.dataRecebimento = consultaDataRecebimento(message);
			this.dataEnvio = consultaDataEnvio(message);
			this.nomePasta = message.getFolder().getFullName();
			this.tipoConteudoEmail = message.getContentType();
			
			this.descricao = message.getDescription();
			this.disposicao = message.getDisposition();
			this.nomeArquivoEmail = message.getFileName();
			//this.arrayEntrada = message.getInputStream();
			this.arrayEntrada = null;
			this.numeroLinhas = message.getLineCount();
			this.tamanho = message.getSize();
			this.pastaGravacaoEmail = saveDirectory  + File.separator + indiceListaPasta;
			
			criaPastaEmailSeraGravado();
			
			this.conteudoEmail = new ConteudoEmail(tipoConteudoEmail, message.getContent(), pastaGravacaoEmail);
			
			gravarEmail();
		}  catch (MessagingException ex) {
			System.out.println("Could not connect to the message store");
			ex.printStackTrace();
			log.error(ex);
			ocorreuErroDuranteGeracaoEmail = true;
		} catch (IOException ex) {
			ex.printStackTrace();
			log.error(ex);
			ocorreuErroDuranteGeracaoEmail = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex);
			ocorreuErroDuranteGeracaoEmail = true;
		}
	}
	
	private List<String> convertFlagsToList(Flags flags) {
		return Arrays.asList(flags.getUserFlags());
	}

	private void criaPastaEmailSeraGravado() {
		File directoryFileGravacaoEmail = new File(this.pastaGravacaoEmail);
		
		if (!directoryFileGravacaoEmail.exists()) {
			directoryFileGravacaoEmail.mkdirs();
		}
		
	}
	
	public void gravarEmail() {
		 try {
			String fileName = this.pastaGravacaoEmail + File.separator + "email.json";
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			String conteudoArquivoEmail = gson.toJson(this);
			out.println(conteudoArquivoEmail);
			out.close();
			
			System.out.println(fileName);
			
//			System.out.println("####################################################################################################################################################");
//			System.out.println("####################################################################################################################################################");
//			System.out.println(conteudoArquivoEmail);
//			System.out.println("####################################################################################################################################################");
//			System.out.println("####################################################################################################################################################");
		} catch (IOException e) {
			/* TODO: exception handling */ e.printStackTrace();
		}
	}
	
	private static Map<String, String> convertHeadersToHashMap(Enumeration enumeration) {
		Map<String,String> listaHeaders = new HashMap<>();
		
		List<Header> list = Collections.list(enumeration);
		for (Header header : list) {
			listaHeaders.put(header.getName(), header.getValue());
		}
		
		return listaHeaders;
	}

	private static List<String> convertArrayAdressToListEmails(Address[] allRecipients) {
		List<String> listaemails = new ArrayList<>();
		
		if (allRecipients == null || allRecipients.length <= 0 ) {
			return listaemails;
		}
		
		List<Address> listaAddress = Arrays.asList(allRecipients);
		
		if ( listaAddress != null )
		for (Address address : listaAddress) {
			listaemails.add(address.toString());
		} 
		
		return listaemails;
	}
	
	private static String consultaDataRecebimento(Message message) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		String dataRetorno = "";
		
		try {
			Date dataRecebimento = message.getReceivedDate();
			
			if (dataRecebimento != null) {
				dataRetorno = simpleDateFormat.format(dataRecebimento);
			}
		} catch (MessagingException e) {
			dataRetorno = "";
		}
		
		return dataRetorno;
	}
	
	private static String consultaDataEnvio(Message message) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		String dataRetorno = "";
		
		try {
			Date dataEnvio = message.getSentDate();
			
			if (dataEnvio != null) {
				dataRetorno = simpleDateFormat.format(dataEnvio);
			}
		} catch (MessagingException e) {
			dataRetorno = "";
		}
		
		return dataRetorno;
	}


	
}
