import java.util.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class GameController {
	
   private Random randomGen = new Random();
   private Scanner player = new Scanner(System.in);
   private Player player1;
   private Player player2; 
   private Board board;
   private MainGui gui;
   private boolean player1Turn;
   private static GameController instance;
   private boolean firstMove;
   private boolean gameStart;
	

   private GameController()
   {
      board = new Board();
      gui = new MainGui(board);
      gui.setWScore(board.getNumWhite());
      gui.setBScore(board.getNumBlack());
      Cell human = Cell.BLACK;
      Cell computer = Cell.WHITE;
      player1 = new HumanPlayer(human);
      player2 = new HardComputerPlayer(computer);
      player1Turn = true;
      firstMove = true;
      gameStart = true;
   //	newGame(board, p1, p2);
   	
   
   }
	
	
/*   public GameController( int x )
   {
      Board board = new Board();
      board.initialize();
      System.out.println(board);
      Cell human1 = Cell.BLACK;
      Cell human2 = Cell.WHITE;
      HumanPlayer p1 = new HumanPlayer(human1, board);
      HumanPlayer p2 = new HumanPlayer(human2, board);
   	//newGame(board, p1, p2);
   	
   }
	
   public GameController( HumanPlayer P1, HumanPlayer P2)
   {
      Board board = new Board();
      board.initialize();
      System.out.println(board);
      HumanPlayer p1 = P1;
      HumanPlayer p2 = P2;
   	//newGame(board, p1, p2);
   	
   }*/
	
   public static GameController getInstance(){
      if(instance == null)
         instance = new GameController();
      return instance;
   }
   
   public void setPlayer1(Player newPlayer){
      player1 = newPlayer;
   }
   
   public void setPlayer2(Player newPlayer){
      player2 = newPlayer;
   }
   
   public void runGame(){
      while(!board.isGameOver() && gameStart)
         instance.gameStep();
      gameStart = false;
      if(board.getNumBlack() > board.getNumWhite())
         gui.status.setText("BLACK Wins!");
      else if(board.getNumBlack() < board.getNumWhite())
         gui.status.setText("WHITE Wins!");
      else
         gui.status.setText("It's a Tie Game!");
   }
	
   public void playerMove(int row, int column){
      if(player1Turn && (player1 instanceof HumanPlayer)
         && board.canMoveHere(Cell.BLACK, row, column)){
         int[] move = ((HumanPlayer)player1).move(board, row, column);
         board.play(Cell.BLACK, move[0], move[1]);
         player1Turn = false;
         if(board.canWhiteMove())
            gui.status.setText("WHITE's Move");
      }
      else if(!player1Turn && player2 instanceof HumanPlayer && 
               board.canMoveHere(Cell.WHITE, row, column)){
         int[] move = ((HumanPlayer)player2).move(board, row, column);
         board.play(Cell.WHITE, move[0], move[1]);
         player1Turn = true;
         if(board.canBlackMove())
            gui.status.setText("BLACK's Move");
      }
   }
	
   public void gameStep()
   {
      if(player1Turn && gui.bText != null && gui.wText != null) {
            gui.bText.setText("Black: " + board.getNumBlack());
            gui.wText.setText("White: " + board.getNumWhite());

         if(!firstMove && !board.canBlackMove()){
            gui.status.setText("BLACK has no moves, WHITE gets to move again!");
            player1Turn = false;
         }
         else if (!(player1 instanceof HumanPlayer))
         {
            int[] move = player1.move(board);
            board.play(Cell.BLACK, move[0], move[1]);
            player1Turn = false;
            firstMove = false;
         }
      		// Change player turn
      }
      else
      {
         if(!board.canWhiteMove()){
            gui.status.setText("WHITE has no moves, BLACK gets to move again!");
            player1Turn = true;
         }
         else if (!(player2 instanceof HumanPlayer)){
            int[] move = player2.move(board);
            try {
               Thread.sleep(750);
               board.play(Cell.WHITE, move[0], move[1]);
               if(board.canBlackMove())
                  gui.status.setText("BLACK's Move");
               gui.manualRepaint();
            }catch(Exception e) {
               e.printStackTrace();
            }
            player1Turn = true;
         }
      }
   }
   
   public void reset(){
      board.initialize();
      firstMove = true;
      gui.resetBoard();
      gameStart = true;
   }
}
	
	
	
	
	/*	public Player getWinner(Board board)
	 *   {
	 *	/  HumanPlayer john = new HumanPlayer('b', board);
	 *	   return john; 
	 *  }
	 */  


