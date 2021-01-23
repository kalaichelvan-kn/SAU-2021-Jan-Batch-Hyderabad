import java.util.HashMap;

public class CakeFactory {
   private static final HashMap<String, Cake> cakeMap = new HashMap<>();
   public static CakeInterface getCake(String cakeType) {
      if(cakeMap.containsKey(cakeType)){
         return cakeMap.get(cakeType);
      }
      System.out.println("new cake of type : " + cakeType);
      cakeMap.put(cakeType, new Cake(cakeType));
      return cakeMap.get(cakeType);
   }
}