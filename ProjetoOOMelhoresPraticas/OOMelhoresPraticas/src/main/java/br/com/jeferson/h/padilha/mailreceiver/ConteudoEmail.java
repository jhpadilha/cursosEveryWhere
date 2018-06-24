package br.com.jeferson.h.padilha.mailreceiver;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class ConteudoEmail {

	private String saveDirectory;
	private List<StringBuilder> subConteudos;
	private Map<String, String> anexos;
	private String tipoConteudo;

	public ConteudoEmail(String tipoConteudo, Object todoConteudo, String saveDirectory)
			throws MessagingException, IOException, Exception {
		this.subConteudos = new ArrayList<StringBuilder>();
		this.anexos = new HashMap<String, String>();
		this.saveDirectory = saveDirectory;
		this.tipoConteudo = tipoConteudo;

		geraConteudo(todoConteudo);
	}

	private void geraConteudo(Object todoConteudo) throws MessagingException, IOException, Exception {
		// TODO Auto-generated method stub

		// store attachment file name, separated by comma

		if (tipoConteudo.contains("multipart")) {
			// content may contain attachments
			Multipart multiPart = (Multipart) todoConteudo;
			int numberOfParts = multiPart.getCount();
			for (int partCount = 0; partCount < numberOfParts; partCount++) {
				MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);

				if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
					// this part is attachment
					String fileName = getFileName(part);
					String caminhoCompleto = saveDirectory + File.separator + fileName;

					anexos.put(fileName, caminhoCompleto);
					part.saveFile(caminhoCompleto);
				} else {
					// this part may be the message content
					addSubConteudo(part.getContent());
				}
			}

		} else if (tipoConteudo.contains("text/plain") || tipoConteudo.contains("text/html")) {
			subConteudos.add(new StringBuilder(todoConteudo.toString()));
		}

	}

	private void addSubConteudo(Object content) throws Exception {
		if (content != null) {
			if (content instanceof MimeMultipart) {
				subConteudos.add(
						new StringBuilder(getTextFromMimeMultipart((MimeMultipart) content)));
			} else {
				subConteudos.add(new StringBuilder(content.toString()));
			}
		}
	}

	public List<StringBuilder> getConteudoEmailDivididoEmPartes() {
		return subConteudos;
	}

	public String retornaConteudoEmailComSeparacaoDasMultipartes() {
		StringBuilder conteudoFinal = new StringBuilder();
		for (StringBuilder subConteudo : subConteudos) {

			if (conteudoFinal.length() > 1) {
				String linhaSeparadora = "/n/n----------------------------------------------------------------------------------------------------------------------------------------------------------";
				conteudoFinal.append(linhaSeparadora);
				conteudoFinal.append(linhaSeparadora);
				conteudoFinal.append("/n/n/n");
			}
			conteudoFinal.append(subConteudo);
		}

		return conteudoFinal.toString();
	}

	public String retornaConteudoEmail() {
		StringBuilder conteudoFinal = new StringBuilder();
		for (StringBuilder subConteudo : subConteudos) {

			if (conteudoFinal.length() > 1) {
				conteudoFinal.append("/n/n");
			}
			conteudoFinal.append(subConteudo);
		}

		return conteudoFinal.toString();
	}

	public Map<String, String> retornaArquivosEmAnexo() {
		return this.anexos;
	}

	public String retornaArquivosAnexo() {
		List<String> arquivosAnexo = new ArrayList<String>(this.anexos.keySet());
		StringBuilder arquivosEmAnexoSaida = new StringBuilder();

		for (String nomeArquivo : arquivosAnexo) {

			if (arquivosEmAnexoSaida.length() > 1) {
				arquivosEmAnexoSaida.append("; ");
			}

			arquivosEmAnexoSaida.append(nomeArquivo);
		}

		return arquivosEmAnexoSaida.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static String getFileName(Part part) throws MessagingException, UnsupportedEncodingException {
		if (!(part instanceof MimeBodyPart)) {
			return part.getFileName();
		}
		String contentType = part.getContentType();
		String ret = null;
		try {
			ret = javax.mail.internet.MimeUtility.decodeText(part.getFileName());
		} catch (NullPointerException ex) {
			String[] contentId = part.getHeader("Content-ID");
			if (contentId != null && contentId.length > 0) {
				ret = contentId[0];
			}
			if (contentId == null) {
				ret = "no-name";
			}
			ret += "." + contentType.substring(contentType.lastIndexOf("/") + 1, contentType.length());
		}
		return ret == null ? "" : ret;
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		String result = "";
		int partCount = mimeMultipart.getCount();
		for (int i = 0; i < partCount; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result = result + "\n" + bodyPart.getContent();
				break; // without break same text appears twice in my tests
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				// result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
				result = html;
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
			}
		}
		return result;
	}
}

// try {
// JSONObject json = new JSONObject();
// json.put("string", myString);
// String converted = json.getString("string");
//
// } catch (JSONException e) {
// e.printStackTrace();
// }
