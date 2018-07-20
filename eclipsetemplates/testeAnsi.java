package com.procergs.gfi.dividaativa.arquivocadin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class testeAnsi {
  
  public static void main(String[] args) {
    
    try {
      String linha1 = "000001IGFIDA2017000001             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Fisica Teste                           000000000000007606034729000000000                                                                           00000000                                                             ";
      String linha2 = "000002SGFIDA2017000001             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Fisica Teste                           000000000000007606034729000000000Suspensão do processo de cobrança de Dívida Ativa (DETRAN) de multas       20781231                                                             ";
      String linha3 = "000003CGFIDA2017000001             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Fisica Teste                           000000000000007606034729000000000Cancel. suspensão dev. Dívida Ativa (DETRAN) de cobrança multas de trâns.  00000000                                                             ";
      String linha4 = "000004BGFIDA2017000001             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Fisica Teste                           000000000000007606034729000000000Remoção do devedor de Dívida Ativa (DETRAN) de cobrança de multas de trâns.00000000                                                             ";
      String linha5 = "000005IGFIDA2017000002             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Juridica Teste                         149568830001120000000000000000000                                                                           00000000                                                             ";
      String linha6 = "000006SGFIDA2017000002             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Juridica Teste                         149568830001120000000000000000000Suspensão do processo de cobrança de Dívida Ativa (DETRAN) de multas       20781231                                                             ";
      String linha7 = "000007CGFIDA2017000002             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Juridica Teste                         149568830001120000000000000000000Cancel. suspensão dev. Dívida Ativa (DETRAN) de cobrança multas de trâns.  00000000                                                             ";
      String linha8 = "000008BGFIDA2017000002             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Juridica Teste                         149568830001120000000000000000000Remoção do devedor de Dívida Ativa (DETRAN) de cobrança de multas de trâns.00000000                                                             ";
  
      
      System.out.println(linha1 +"\n"+ new String(linha1.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      System.out.println(linha2 +"\n"+ new String(linha2.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      System.out.println(linha3 +"\n"+ new String(linha3.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      System.out.println(linha4 +"\n"+ new String(linha4.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      System.out.println(linha5 +"\n"+ new String(linha5.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      System.out.println(linha6 +"\n"+ new String(linha6.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      System.out.println(linha7 +"\n"+ new String(linha7.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      System.out.println(linha8 +"\n"+ new String(linha8.getBytes("UTF-8"),Charset.forName("Cp1252")) );
      
      String[] codes = { 
          "ASCII", 
          "Cp1252", 
          "ISO-8859-1", //ISO-latin-1 
          "ISO-8859-9", 
          "UTF-8", 
          "UTF-16",
          "UTF-16BE",
          "UTF-16LE",
          "US-ASCII", 
          "WINDOWS-1252" 
          };
      
      String palavra = "çã";
       
      for (String encoding : codes) {
        byte[] b = palavra.getBytes(encoding);
        System.out.printf("%10s\t%d\n\t", encoding, b.length);
        System.out.print(new String(palavra.getBytes("Cp1252"), encoding) + "\t||");
        System.out.print(new String(palavra.getBytes(encoding)) + "\t||");
        for (int k = 0; k < b.length; k++) {
          String hex = Integer.toHexString((b[k] + 256) % 256);
          if (hex.length() == 1)
            hex = "0" + hex;
          System.out.print(hex + "\t||");
          
        }
        System.out.println();
      }
      
    }catch(Exception exc){
      System.out.println(exc);
    }
    writeFileOnServer();
  }
  
  public static void writeFileOnServer(){
    String newLine = "\r\n";
    File arquivo = new File("\\\\rsfs02\\TESTE\\gfi\\saida\\dividaativa\\CADIN\\teste.txt");
    String linha1 = "000001IGFIDA2017000001             207812310000000000000000000000000COBRANÇA DE DÍVIDA ATIVA (DETRAN) POR NÃO PAGAMENTO DE MULTAS DE TRÂNSITO  0001Pessoa Fisica Teste                           000000000000007606034729000000000                                                                           00000000                                                             ";
    
    PrintWriter writer = null;

    try {
      writer = new PrintWriter(arquivo,"Cp1252");
      
      writer.print(linha1+ newLine);
      writer.print(linha1+ newLine);
      
      if (writer != null) {
        writer.close();
        writer = null;
      }
      
    } catch (Exception e) {
    } 
    
  }

}

C:\Procergs\Projetos\Sistemas\GFI\Scripts
