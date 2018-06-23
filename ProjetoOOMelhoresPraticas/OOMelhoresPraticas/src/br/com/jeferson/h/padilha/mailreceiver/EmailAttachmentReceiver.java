package br.com.jeferson.h.padilha.mailreceiver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;

import org.apache.log4j.Logger;

import com.google.gson.Gson;


/**
 * This program demonstrates how to download e-mail messages and save
 * attachments into files on disk.
 * 
 * @author simbu
 * 
 */
public class EmailAttachmentReceiver {
	/** log4j Logger */
	private static Logger log = Logger.getLogger(EmailAttachmentReceiver.class); 
	
	private static String saveDirectory = "/home/content"; // directory to save the downloaded documents

	/**
	 * Sets the directory where attached files will be stored.
	 * @param dir absolute path of the directory
	 */
	public void setSaveDirectory(String dir) {
		EmailAttachmentReceiver.saveDirectory = dir;
	}

	/**
	 * Downloads new messages and saves attachments to disk if any.
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
//	 */
//	public static void downloadEmailAttachments(String host, String port, String userName, String password) {
//		
//
//		// server setting
//		
//
//		try {
//			// connects to the message store
//			
//
//			// opens the inbox folder
//			Folder folderInbox = store.getFolder("INBOX");
//			folderInbox.open(Folder.READ_ONLY);
//
//			// fetches new messages from server
//			Message[] arrayMessages = folderInbox.getMessages();
//
//			// for (int i = 0; i < arrayMessages.length; i++) {
//			for (int i = 0; i < 1; i++) {
//				Message message = arrayMessages[i];
//				
//				new Email(message, saveDirectory);
//				
//				
//				/*print out details of each message
//				System.out.println("Message #" + (i + 1) + ":");
//				System.out.println("\t From: " + from);
//				System.out.println("\t Subject: " + subject);
//				System.out.println("\t Sent Date: " + sentDate);
//				System.out.println("\t Message: " + messageContent);
//				System.out.println("\t Attachments: " + attachFiles);*/
//			}
//
//			// disconnect
//			folderInbox.close(false);
//			store.close();
//		} /*catch (NoSuchProviderException ex) {
//			System.out.println("No provider for pop3.");
//			ex.printStackTrace();
//			log.error(ex);
//		}*/ catch (MessagingException ex) {
//			System.out.println("Could not connect to the message store");
//			ex.printStackTrace();
//			log.error(ex);
//		}
//	}
//	
	

	public static void main(String[] args) {
		
		String userName = "jh.padilha@gmail.com"; //username for the mail you want to read
		String password = "JNew4865"; //password

		String saveDirectory = "C:\\attachs\\";

		EmailAttachmentReceiver receiver = new EmailAttachmentReceiver();
		receiver.setSaveDirectory(saveDirectory);
		//EmailAttachmentReceiver.downloadEmailAttachments(host, port, userName, password);

	} 
}