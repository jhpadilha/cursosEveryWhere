import java.util.HashMap;
import java.util.Map;

public class MappingComChaveDuplicada {

  public static void main(String[] args) {
    Map<Integer, String> teste = new HashMap<Integer, String>();
    
    teste.put(Integer.valueOf(1), "teste 01");
    teste.put(Integer.valueOf(1), "teste 02");
    
    for (Integer chave : teste.keySet()) {
      String conteudo = teste.get(chave);
      System.out.println("O conteúdo da chave \""+ chave + "\" é : \""+conteudo+"\"");
    }
  }

}
