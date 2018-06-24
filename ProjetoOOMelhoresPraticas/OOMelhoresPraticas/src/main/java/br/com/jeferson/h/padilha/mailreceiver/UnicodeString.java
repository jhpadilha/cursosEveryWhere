package br.com.jeferson.h.padilha.mailreceiver;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class UnicodeString {
	public String convert(String str) {
		StringBuffer ostr = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			/* caracter precisa ser convertido para unicode? */
			if ((ch >= 0x0020) && (ch <= 0x007e)) {
				/* não */
				ostr.append(ch);
			} else {
				/* sim */
				ostr.append("\\u"); /* formato de unicode padrão */
				/* pega o valor hexadecimal do caracter */
				String hex = Integer.toHexString(str.charAt(i) & 0xFFFF);
				for (int j = 0; j < 4 - hex.length(); j++) {
					/* concatena o zero porque o unicode requer 4 digitos */
					ostr.append("0");
				}
				ostr.append(hex.toLowerCase());
			}
		}
		return (new String(ostr));
	}
	public static void main(String[] args) {
		String texto = "endereço";
		System.out.println(new UnicodeString().convert(texto));
		System.out.println(new UnicodeString().convert("endere\\u00e7o"));
		
		try {
			byte array[] = texto.getBytes("UTF-8");
			String novaString = new String(array, "ISO-8859-1");
			System.out.println(novaString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] codes = { "ISO-8859-1", "UTF-8", "UTF-16", "CP1252" };
		
		
		
		try {
	
		
		String palavra = "=";
		 
		for (String encoding : codes) {
		  byte[] b = palavra.getBytes(encoding);
		  System.out.printf("%10s\t%d\t", encoding, b.length);
		  for (int k = 0; k < b.length; k++) {
		    String hex = Integer.toHexString((b[k] + 256) % 256);
		    if (hex.length() == 1)
		      hex = "0" + hex;
		    System.out.print(hex);
		  }
		  System.out.println();
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private String removeUnicodeCharacters(String textWithUnicode) {
//		 byte[] bytes = textWithUnicode.getBytes(StandardCharsets.UTF_8);
//		 String textWithouthUnicodeCharacters = new String(bytes,
//		 StandardCharsets.UTF_8);
//		 System.out.println("\n"+textWithUnicode);
//		 System.out.println("\n" + textWithouthUnicodeCharacters+"\n");
//		 return textWithouthUnicodeCharacters;
		 

		// return StringEscapeUtils.unescapeJava(textWithUnicode);

//		return forceUtf8Coding(textWithUnicode);
		return forceUtf8Coding(textWithUnicode);
	}
	
	private static final Charset UTF_8 = Charset.forName("UTF-8");
	private static final Charset WIN = Charset.forName("Windows-1252");
	

	private String forceUtf8Coding(String input) {
		return new String(input.getBytes(WIN), UTF_8);
	}
	
}
