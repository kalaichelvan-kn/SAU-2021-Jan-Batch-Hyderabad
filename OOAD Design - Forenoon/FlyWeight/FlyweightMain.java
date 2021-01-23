public class FlyweightMain {
   private static final String cakes[] = { "RedVelvet", "Chocolate", "Chocolate", "RedVelvet", "IceCream", "IceCream", "Chocolate", "BlackForest"};
   private static final int cakeSizes[] = { 1 , 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
   public static void main(String[] args) {
      for(String cakeType : cakes) {
         Cake cake = (Cake) CakeFactory.getCake(cakeType);
         cake.setSize(getRandomCakeSize());
         cake.bake();
      }
   }
   private static int getRandomCakeSize() { return cakeSizes[(int)(Math.random()*cakeSizes.length)]; }
}