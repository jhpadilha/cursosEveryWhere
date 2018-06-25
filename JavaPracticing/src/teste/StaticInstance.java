package teste;

public class StaticInstance {
  
  // one way, with final
  //private static final StaticInstance instance = new StaticInstance();
  
  //Second way, with synchronized
  private static StaticInstance instance;
  
  public static StaticInstance getInstance(){
    synchronized(StaticInstance.class){
      if (instance == null){
        instance = new StaticInstance();
      }
    }
    
    return instance;
  }

}
