
public class BoardTest {

	public static void main(String[] args) {
		Board board = new Board();
		board.initialize();
		System.out.println(board);
		
		System.out.println(board.isBlack(0, 0));
		System.out.println(board.isWhite(0, 0));
		System.out.println(board.isWhite(1, 5));
		System.out.println(board.isBlack(1, 5));
		System.out.println(board.isEmpty(1, 1));
		
		
	
		
	}

}
