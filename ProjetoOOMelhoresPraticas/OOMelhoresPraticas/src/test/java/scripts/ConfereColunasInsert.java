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
    String colunas = "NRO_INT_DA_PROCESSO, ANO_PROCESSO, NRO_PROCESSO, NRO_INT_DA_FASE, NRO_INT_DA_PESSOA_PROCESSO, IND_SITUACAO, CTR_ORG_ATU, CTR_ORG_INC, CTR_USU_ATU, CTR_USU_INC, CTR_DTH_ATU, CTR_DTH_INC, CTR_NRO_IP_ATU, CTR_NRO_IP_INC, CTR_USU_SOE_INC, CTR_USU_SOE_ATU";
    String valores = "1, 2018, 1, 1, 1, 'A', 'SISTEMA', 'PROCERGS', 4039, 56879, to_date('12-07-2018 11:00:29', 'dd-mm-yyyy hh24:mi:ss'), to_date('23-05-2018 09:46:05', 'dd-mm-yyyy hh24:mi:ss'), '0.0.0.0', '172.28.3.205', 5053, 12835";
    
//    String colunas = "NRO_INT_DA_PESSOA_PROCESSO, TP_PESSOA, NRO_CPF_PESSOA_FISICA, NOME_PESSOA_FISICA, TXT_DOC_IDENT_PESSOA_FISICA, TXT_UF_DOC_IDENT_PESSOA_FISICA, NRO_CNPJ_PESSOA_JURIDICA, TXT_RAZAO_SOCIAL_PESSOA_JURID, NRO_INT_DA_ENDERECO_PESSOA, CTR_ORG_ATU, CTR_ORG_INC, CTR_USU_ATU, CTR_USU_INC, CTR_DTH_ATU, CTR_DTH_INC, CTR_NRO_IP_ATU, CTR_NRO_IP_INC, CTR_USU_SOE_INC, CTR_USU_SOE_ATU";
//    String valores = "1, '1', 99199299344, 'FULANO TESTE 1', null, null, null, null, 1, null, 'PROCERGS', null, 56879, null, to_date('27-12-2017 11:30:24', 'dd-mm-yyyy hh24:mi:ss'), null, '172.28.3.205', 5423, null";
//    
    
//  String colunas = "NRO_INT_DA_INFRACAO_PROCESSO, COD_ORGAO_AUTUADOR_TRANSITO, NSU_AUTO_INFRACAO, VLR_INFRACAO_ORIGINAL, VLR_JUROS, VLR_MULTA, DT_VENCIMENTO_INFRACAO, NRO_INT_DA_PROCESSO, IND_VINCULADA, IND_PAGA, CTR_ORG_ATU, CTR_ORG_INC, CTR_USU_ATU, CTR_USU_INC, CTR_DTH_ATU, CTR_DTH_INC, CTR_NRO_IP_ATU, CTR_NRO_IP_INC, TXT_PLACA_VEICULO, IND_NOVA_ANTIGA, NRO_INT_DA_PAGTO_GUIA, IND_EXCLUIDA, NRO_GUIA_AUTO_INFRACAO, CTR_USU_SOE_INC, CTR_USU_SOE_ATU, IND_QUITADA_SIT, VLR_INSCRICAO_DIVIDA_ATIVA, VLR_ULTIMA_ATUALIZACAO_INFR";
//  String valores = "1, 121101, 'BM99900001', 100.00, 0.00, 0.00, to_date('20-06-2014', 'dd-mm-yyyy'), 1, 'S', 'N', 'SISTEMA', 'PROCERGS', 4038, 60574, to_date('14-12-2017 17:13:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-08-2017 13:51:13', 'dd-mm-yyyy hh24:mi:ss'), '0.0.0.0', '127.0.0.1', 'IUI7771', 'A', null, 'N', null, 9604, 12834, 'N', null, null";
//  String valores = "2, 121101, 'BM99900002', 100.00, 0.00, 0.00, to_date('20-06-2014', 'dd-mm-yyyy'), 1, 'S', 'N', 'SISTEMA', 'PROCERGS', 4038, 60574, to_date('14-12-2017 17:13:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-08-2017 13:51:13', 'dd-mm-yyyy hh24:mi:ss'), '0.0.0.0', '127.0.0.1', 'IUI7772', 'A', null, 'N', null, 9604, 12834, 'N', null, null";
//  String valores = "3, 121101, 'BM99900003', 100.00, 0.00, 0.00, to_date('20-06-2014', 'dd-mm-yyyy'), 1, 'S', 'N', 'SISTEMA', 'PROCERGS', 4038, 60574, to_date('14-12-2017 17:13:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-08-2017 13:51:13', 'dd-mm-yyyy hh24:mi:ss'), '0.0.0.0', '127.0.0.1', 'IUI7773', 'A', null, 'N', null, 9604, 12834, 'N', null, null";
//  String valores = "4, 121101, 'BM99900004', 100.00, 0.00, 0.00, to_date('20-06-2014', 'dd-mm-yyyy'), 1, 'S', 'N', 'SISTEMA', 'PROCERGS', 4038, 60574, to_date('14-12-2017 17:13:13', 'dd-mm-yyyy hh24:mi:ss'), to_date('09-08-2017 13:51:13', 'dd-mm-yyyy hh24:mi:ss'), '0.0.0.0', '127.0.0.1', 'IUI7774', 'A', null, 'N', null, 9604, 12834, 'N', null, null";
  
    
    new ConfereColunasInsert(colunas,valores);
  }
  
  

}
