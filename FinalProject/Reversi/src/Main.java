public class Main{
   public static void main(String[] args) 
   {
      GameController theGame = GameController.getInstance();
      while(true)
         theGame.runGame();
   }
}