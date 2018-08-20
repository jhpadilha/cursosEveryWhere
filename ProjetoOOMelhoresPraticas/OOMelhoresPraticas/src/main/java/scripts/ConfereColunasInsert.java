package scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

public class ConfereColunasInsert {
  
  private List<String> listaNomes;
  private List<String> listavalores;
  
  private Map<String,String> mapeamento = new HashMap<String,String>();
  
  public ConfereColunasInsert(String nomesColunas, String valoresColunas) {
    
    listaNomes = Arrays.asList(nomesColunas.split(","));
    listavalores = converteValoresComandoSqlParaLista(valoresColunas);

    geraMapeamento();
    
    printConsole();
  }

  private List<String> converteValoresComandoSqlParaLista(String valoresColunas) {
    List<String> listaComValores = new ArrayList<String>();
    
    List<String> listaum = Arrays.asList(valoresColunas.split("to_|\\)\\s{0,4}," ));
    //System.out.println("LIST_UM=" + listaum);
    for (String string : listaum) {
      if (string.contains("(")){
        listaComValores.add("to_"+string.trim()+")");
      }else{
        List<String> listaDois = Arrays.asList(string.split("," ));
        //System.out.println("LISTA DOIS=" + listaDois);
        for (String subString : listaDois) {
          if (!subString.trim().equals("")){
            listaComValores.add(subString.trim());
          }
        }
      }
    }
    
    return listaComValores;
  }

  private void printConsole() {
    new TreeMap<String, String>(mapeamento).forEach((k,v) -> System.out.println(StringUtils.rightPad(k+ "=", 45, " ")  + v));    
  }

  private void geraMapeamento() {
    
    int tamanhoListaValores = listavalores.size();
    int tamanhoListaNomes = listaNomes.size();
    int maiorTamanho = tamanhoListaValores > tamanhoListaNomes ? tamanhoListaValores : tamanhoListaNomes;
    
    for (int i = 0; i < maiorTamanho; i++) {
      String nomeCampo = "Col "+ StringUtils.leftPad(String.valueOf(i+1), 3, "0") + " - " + (i < listaNomes.size() ? listaNomes.get(i).trim() : "");
      String valorCampo = i < listavalores.size() ? listavalores.get(i) : "<No Value>";
      
      mapeamento.put(nomeCampo, valorCampo);
      
      
    }
    
  }
  
  
  public static void main(String[] args) {
    
    
    String colunas = "K787_NRO_SEQ_NSA, K787_BANCO, K787_AGENCIA, K787_SAMD_PAGTO, K787_HMS_PAGTO, K787_FORMA_PAGTO, K787_SAMD_MOVTO, K787_SAMD_CRED, K787_MAQUINA, K787_ORIGEM_PAGTO, K787_EXERC_PAGTO, K787_COD_PAGTO, K787_COD_ESTORNO, K787_AUTENTICACAO, K787_TR, K787_DESDOBRADO, K787_STATUS, K787_FORMA_ARRECA, K787_FLUXO_FINANC, K787_COD_TARIFA, K787_VERSAO_TAB, K787_INCLUSAO, K787_COD_INDIV, K787_NRO_RENAVAM, K787_NRO_PROCESSO, K787_IND_INCONSISTENCIA, K787_FORM_RENACH, K787_EXERC_DPVAT, K787_VALOR_IOF, K787_COD_PAG_COR, K787_NRO_RPV, K787_TIPO_MOEDA, K787_IND_DUPLICIDADE, K787_NSU, K787_PLACA_NRO, K787_PLACA, K787_COD_BARRAS, K787_NRO_GUIA, K787_VALOR, K787_ORIGEM, K787_NSA, K787_NSR, K787_VER_LAYOUT, K787_TIPO_OCOR, K787_RETROATIVO, K787_TIPO_PAGTO, K787_NRO_LEILAO, K787_NRO_LOTE, K787_SAMD_TRA, K787_SAMD_TRANS, K787_HMS_TRANS";
    String valores = "646672, 41, 220, 20170628, 94100, 19, 20170628, 20170628, 9996, 8, 2018, 7771, 0, '           009996294670', 1, 1, 1, 1, 8, 0, 0, 3, 0, 281557357, 0, 0, ' ', 0, 0.00, 0, 0, 0, 0, 294670, 9181581894, 'JEF7771', '85610000004345000742017062800590559830000002', 59055983, 434.50, 2, 120300, 607, 3, 0, 0, 1, 0, 0, 20170629, 20170628, 101628";
    
 
    
    new ConfereColunasInsert(colunas,valores);
  }
  
  

}
