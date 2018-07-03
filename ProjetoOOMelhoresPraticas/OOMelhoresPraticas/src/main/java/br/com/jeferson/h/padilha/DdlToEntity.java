package br.com.jeferson.h.padilha;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DdlToEntity {

  /*
   * 
   * ? >> {0,1} >> nenhuma ou uma
   * + >> {1,}  >> uma ou mais
   * * >> {,}   >> nenhuma ou mais
   * {n}        >> n vezes
   * 
   * [-.] >> "-" or "."
   * [0123456789] >> "0" or "1" or "2" or "3" or "4" or "5" or "6" or "7" or "8" or "9"
   * [0-9]
   * [A-Z]
   * [a-z]
   * \s >> Space >> e é um atalho para [ \t\r\n\f].
   * \d >> digitos >> [0-9]
   * \w >> caracteres >> [A-Za-z0-9]  
   * 
   * Todo qualifier que estivwer  dentro dos colchetes vira caractere
   * Literais Regex :
   * [.?+*{}]
   * 
   * Ancocoras: 
   * O que queremos na verdade é encontrar o início e o fim
   * 
   * boundary 
   * \b >> evita que tenham caracteres (\w) no inicio ou no fim
   * 
   *  
   * 
   * Matchers :
   * 
   * IP 
   * \d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}
   * 
   * Cep
   * \d{5}-\d{3}
   * 
   * (21) 3216-2345
   * \(\d{2}\) \d{4}-\d{4}
   * 
   * 19h32min16s
   * \d{2}h\d{2}min\d{2}s
   * \[0-9]{2}h\[0-9]{2}min\[0-9]{2}s
   * [0-9]{2}h[0-9]{2}min[0-9]{2}s
   * 
   * KMG-8089
   * [A-Z]{3}-\d{4}
   * 
   * ?classes+poderosas*
   * [a-z?*+]+
   * 
   * [0123]?\d\s+de\s+[A-Z][a-zç]{1,8}\s+de\s+[12]\d{3}
   * var DIA  = "[0123]?\d"; 
   * var _DE_ = "\s+de\s+";
   * var MES  = "[A-Za-z][a-zç]{1,8}";
   * var ANO  = "[12]\d{3}";
   * 
   * Regex serve para :
   * A) Extraindo seções específicas de uma arquivo de texto
   * B) Validação de formatação de, por exemplo, e-mail ou telefone
   * C) Análise de arquivos de texto e extração de dados para, por exemplo, gravar no banco de dados
   * D) Substituindo os valores de um texto para limpar, reformatar ou alterar o conteúdo
   * 
   */

  public static void main(String[] args) {
    String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";
    Pattern patternOne = Pattern.compile("\\w+");
    Matcher matcherOne = patternOne.matcher(EXAMPLE_TEST);
    while (matcherOne.find()) {
      System.out.print("Start index: " + matcherOne.start());
      System.out.print(" End index: " + matcherOne.end() + " ");
      System.out.println(matcherOne.group());
    }

    System.out.println("-----------------------------------");

    StringBuilder inputDDL = new StringBuilder();
    inputDDL.append("");
    inputDDL.append(" ");
    inputDDL.append("-- Create table ");
    inputDDL.append("create table T_DET_GFI.GFI_DA_PROCESSO ");
    inputDDL.append("( ");
    inputDDL.append("  nro_int_da_processo        NUMBER(10) not null, ");
    inputDDL.append("  ano_processo               NUMBER(4) not null, ");
    inputDDL.append("  nro_processo               NUMBER(6) not null, ");
    inputDDL.append("  nro_int_da_fase            NUMBER(4) not null, ");
    inputDDL.append("  nro_int_da_pessoa_processo NUMBER(10) not null, ");
    inputDDL.append("  ind_situacao               CHAR(1) not null, ");
    inputDDL.append("  ctr_org_atu                VARCHAR2(8), ");
    inputDDL.append("  ctr_org_inc                VARCHAR2(8) not null, ");
    inputDDL.append("  ctr_usu_atu                NUMBER(10), ");
    inputDDL.append("  ctr_usu_inc                NUMBER(10) not null, ");
    inputDDL.append("  ctr_dth_atu                DATE, ");
    inputDDL.append("  ctr_dth_inc                DATE not null, ");
    inputDDL.append("  ctr_nro_ip_atu             VARCHAR2(15), ");
    inputDDL.append("  ctr_nro_ip_inc             VARCHAR2(15) not null, ");
    inputDDL.append("  ctr_usu_soe_inc            NUMBER(10), ");
    inputDDL.append("  ctr_usu_soe_atu            NUMBER(10) ");
    inputDDL.append(") ");
    inputDDL.append("tablespace P_128K ");
    inputDDL.append("  pctfree 10 ");
    inputDDL.append("  initrans 1 ");
    inputDDL.append("  maxtrans 255 ");
    inputDDL.append("  storage ");
    inputDDL.append("  ( ");
    inputDDL.append("    initial 128K ");
    inputDDL.append("    next 128K ");
    inputDDL.append("    minextents 1 ");
    inputDDL.append("    maxextents unlimited ");
    inputDDL.append("    pctincrease 0 ");
    inputDDL.append("  ); ");
    inputDDL.append("-- Add comments to the columns  ");
    inputDDL.append("comment on column T_DET_GFI.GFI_DA_PROCESSO.nro_int_da_processo ");
    inputDDL.append("  is 'Usar sequence: GFI_DA_ID_PROCESSO_SEQ.'; ");
    inputDDL.append("comment on column T_DET_GFI.GFI_DA_PROCESSO.ano_processo ");
    inputDDL.append("  is 'Compõe o número do processo: ANO_PROCESSO + NRO_PROCESSO.'; ");
    inputDDL.append("comment on column T_DET_GFI.GFI_DA_PROCESSO.nro_processo ");
    inputDDL.append("  is 'Compõe o número do processo: ANO_PROCESSO + NRO_PROCESSO. Este campo é zerado a cada troca de ano.'; ");
    inputDDL.append("comment on column T_DET_GFI.GFI_DA_PROCESSO.ind_situacao ");
    inputDDL.append("  is '(A) Em Aberto, (S) Suspenso, (E) Encerrado, (P) Pago, (F) Finalizado'; ");
    inputDDL.append("comment on column T_DET_GFI.GFI_DA_PROCESSO.ctr_usu_soe_inc ");
    inputDDL.append("  is 'Número Interno do SOE que realizou a inclusão do registro.'; ");
    inputDDL.append("comment on column T_DET_GFI.GFI_DA_PROCESSO.ctr_usu_soe_atu ");
    inputDDL.append("  is 'Número Interno do SOE que realizou a atualização do registro.'; ");
    inputDDL.append("-- Create/Recreate indexes  ");
    inputDDL.append("create index T_DET_GFI.CE_FASE_PROCESSO on T_DET_GFI.GFI_DA_PROCESSO (NRO_INT_DA_FASE) ");
    inputDDL.append("  tablespace P_128K ");
    inputDDL.append("  pctfree 10 ");
    inputDDL.append("  initrans 2 ");
    inputDDL.append("  maxtrans 255 ");
    inputDDL.append("  storage ");
    inputDDL.append("  ( ");
    inputDDL.append("    initial 128K ");
    inputDDL.append("    next 128K ");
    inputDDL.append("    minextents 1 ");
    inputDDL.append("    maxextents unlimited ");
    inputDDL.append("    pctincrease 0 ");
    inputDDL.append("  ); ");
    inputDDL.append("create index T_DET_GFI.CE_PESSOA_PROC_PROCESSO on T_DET_GFI.GFI_DA_PROCESSO (NRO_INT_DA_PESSOA_PROCESSO) ");
    inputDDL.append("  tablespace P_128K ");
    inputDDL.append("  pctfree 10 ");
    inputDDL.append("  initrans 2 ");
    inputDDL.append("  maxtrans 255 ");
    inputDDL.append("  storage ");
    inputDDL.append("  ( ");
    inputDDL.append("    initial 128K ");
    inputDDL.append("    next 128K ");
    inputDDL.append("    minextents 1 ");
    inputDDL.append("    maxextents unlimited ");
    inputDDL.append("    pctincrease 0 ");
    inputDDL.append("  ); ");
    inputDDL.append("-- Create/Recreate primary, unique and foreign key constraints  ");
    inputDDL.append("alter table T_DET_GFI.GFI_DA_PROCESSO ");
    inputDDL.append("  add constraint CP_GFI_DA_PROCESSO primary key (NRO_INT_DA_PROCESSO) ");
    inputDDL.append("  using index  ");
    inputDDL.append("  tablespace P_128K ");
    inputDDL.append("  pctfree 10 ");
    inputDDL.append("  initrans 2 ");
    inputDDL.append("  maxtrans 255 ");
    inputDDL.append("  storage ");
    inputDDL.append("  ( ");
    inputDDL.append("    initial 128K ");
    inputDDL.append("    next 128K ");
    inputDDL.append("    minextents 1 ");
    inputDDL.append("    maxextents unlimited ");
    inputDDL.append("    pctincrease 0 ");
    inputDDL.append("  ); ");
    inputDDL.append("alter table T_DET_GFI.GFI_DA_PROCESSO ");
    inputDDL.append("  add constraint CS_ANO_PROCESSO_NRO_PROCESSO unique (ANO_PROCESSO, NRO_PROCESSO) ");
    inputDDL.append("  using index  ");
    inputDDL.append("  tablespace P_128K ");
    inputDDL.append("  pctfree 10 ");
    inputDDL.append("  initrans 2 ");
    inputDDL.append("  maxtrans 255 ");
    inputDDL.append("  storage ");
    inputDDL.append("  ( ");
    inputDDL.append("    initial 128K ");
    inputDDL.append("    next 128K ");
    inputDDL.append("    minextents 1 ");
    inputDDL.append("    maxextents unlimited ");
    inputDDL.append("    pctincrease 0 ");
    inputDDL.append("  ); ");
    inputDDL.append("alter table T_DET_GFI.GFI_DA_PROCESSO ");
    inputDDL.append("  add constraint CT_FASE_PROCESSO foreign key (NRO_INT_DA_FASE) ");
    inputDDL.append("  references T_DET_GFI.GFI_DA_FASE (NRO_INT_DA_FASE) on delete set null; ");
    inputDDL.append("alter table T_DET_GFI.GFI_DA_PROCESSO ");
    inputDDL.append("  add constraint CT_PESSOA_PROC_PROCESSO foreign key (NRO_INT_DA_PESSOA_PROCESSO) ");
    inputDDL.append("  references T_DET_GFI.GFI_DA_PESSOA_PROCESSO (NRO_INT_DA_PESSOA_PROCESSO) on delete set null; ");
    inputDDL.append("-- Create/Recreate check constraints  ");
    inputDDL.append("alter table T_DET_GFI.GFI_DA_PROCESSO ");
    inputDDL.append("  add constraint CK_IND_SITUACAO_PROCESSO ");
    inputDDL.append("  check (IND_SITUACAO IN ('A', 'S', 'E', 'P', 'F')); ");
    inputDDL.append("-- Grant/Revoke object privileges  ");
    inputDDL.append("grant select, insert, update, delete on T_DET_GFI.GFI_DA_PROCESSO to JEFERSON_PADILHA; ");
    inputDDL.append(" ");

    //Pattern pattern = Pattern.compile("\\(.*\\)");
    Pattern pattern = Pattern.compile("\\((.*?)\\)");
    Matcher matcher = pattern.matcher(inputDDL.toString());

    while (matcher.find()) {
      System.out.print("Start index: " + matcher.start());
      System.out.print(" End index: " + matcher.end() + " ");
      System.out.println(matcher.group());
    }

    System.out.println("-----------------------------------");

    String strExample1 = "João Fulano,123.456.789-00,21 de Maio de 1993,(21) 3079-9987,Rua do Ouvidor,50,20040-030,Rio de Janeiro" + "Maria Fulana, 98765432100,11 de Abril de 1995,(11) 933339871,Rua Vergueiro,3185,04101-300,São Paulo" + "denise teste, 987.654.321.00,28 de Dezembro de 1991,(31)45562712,SCS Qd. 8 Bl. B-50,11,70333-900,Rio Grande";

    //Pattern patternEx1 = Pattern.compile("\\d{3}");
    //Pattern patternEx1 = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
    Pattern patternEx1 = Pattern.compile("\\(\\d{2}\\)\\s?\\d+\\-?\\d+");

    Matcher matcherEx1 = patternEx1.matcher(strExample1);
    while (matcherEx1.find()) {
      System.out.println(matcherEx1.group());
    }

    System.out.println("-----------------------------------");

    String strExample2 = "No <code>for</code>, o valor de <code>i</code> começa de zero e é incrementado a cada volta enquanto <code>i < 10</code>, portando o bloco de código do for é executado 10 vezes.";

    Pattern patternEx2 = Pattern.compile("</?code>");

    Matcher matcherEx2 = patternEx2.matcher(strExample2);
    while (matcherEx2.find()) {
      System.out.println(matcherEx2.group());
    }

    System.out.println("-----------------------------------");
    
    String strExample3 = "9.8 - Robson, 7.1 - Teresa, 4.5 - Armênio, 6.5 - Zulu, 7.7 - Stefania, 7.8, 5.0 - Romeu, 7.2 - Pompilho, 3.1 - Reinaldo, 7.3 - Bernadete, 4.7 - Cinério";

    Pattern patternEx3 = Pattern.compile("7\\.[2-9]\\s+-\\s+\\w+");

    Matcher matcherEx3 = patternEx3.matcher(strExample3);
    while (matcherEx3.find()) {
      System.out.println(matcherEx3.group());
    }

    System.out.println("-----------------------------------");
    
    String strExample4 = "BALEIRO GARROTE SERROTE GOLEIRO ROTEIRO";

    //Pattern patternEx4 = Pattern.compile("\\w*ROTE\\w*");
    Pattern patternEx4 = Pattern.compile("[A-Z]*ROT[A-Z]+");

    Matcher matcherEx4 = patternEx4.matcher(strExample4);
    while (matcherEx4.find()) {
      System.out.println(matcherEx4.group());
    }

    System.out.println("-----------------------------------");
    
    String strExample5 = "denise teste, 987.654.321-00,28 de Dezembro de 1991,(31)45562712,SCS Qd. 8 Bl. B-50,11,70333-900,Rio Grande";

    Pattern patternEx5 = Pattern.compile("\\bde\\b");

    Matcher matcherEx5 = patternEx5.matcher(strExample5);
    while (matcherEx5.find()) {
      System.out.println(matcherEx5.group());
    }

    System.out.println("-----------------------------------");
    
    String strExample6 = "aaa aaaa aaa aaaa aaa";

    Pattern patternEx6 = Pattern.compile("\\ba{3}\\b");

    Matcher matcherEx6 = patternEx6.matcher(strExample6);
    while (matcherEx6.find()) {
      System.out.println(matcherEx6.group());
    }

    System.out.println("-----------------------------------");
    
    String strExample7 = "denise teste, 987.654.321-00,28 de Dezembro de 1991,(31)45562712,SCS Qd. 8 Bl. B-50,11,70333-900,Rio Grande";

    Pattern patternEx7 = Pattern.compile("^()$");

    Matcher matcherEx7 = patternEx7.matcher(strExample7);
    while (matcherEx7.find()) {
      System.out.println(matcherEx7.group());
    }

    System.out.println("-----------------------------------");
    
    
  }

}
