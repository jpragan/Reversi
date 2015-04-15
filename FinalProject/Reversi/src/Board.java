

public class Board {

	Cell[][] board = new Cell [9][];

	public Board()
	{
		int j = 5;
		for ( int i = 0; i < 5; i++)
		{
			board[i] = new Cell[j];
			j++;
		}

		j = 8;
		for ( int i = 5; i < 9; i++)
		{
			board[i] = new Cell[j];
			j--;
		}
	}

	public void initialize()
	{
		Chip b = Chip.BLACK;
		Chip w = Chip.WHITE;
		int k = 0;
		int l = 9;
		Cell C = new Cell(b);
		Cell D = new Cell(w);
		for (int i = 0; i < 9; i++)
			for(int j = 0; j < 5; j++)
			{
				board[i][j] = C;
			}
		for (int j = 5; j < 9; j++)
		{
			k++;
			l--;
			for(int i = k; i < l ; i++ )
				board[i][j] = D;
		}
	}

	public String toString()
	{
		return( "    ["+board[0][0]+"]["+board[0][1]+"]["+board[0][2]+"]["+board[0][3]+"]["+board[0][4]+"] \n" +
				"   ["+board[1][0]+"]["+board[1][1]+"]["+board[1][2]+"]["+board[1][3]+"]["+board[1][4]+"]["+board[1][5]+"] \n" +
				"  ["+board[2][0]+"]["+board[2][1]+"]["+board[2][2]+"]["+board[2][3]+"]["+board[2][4]+"]["+board[2][5]+"]["+board[2][6]+"] \n" +
				" ["+board[3][0]+"]["+board[3][1]+"]["+board[3][2]+"]["+board[3][3]+"]["+board[3][4]+"]["+board[3][5]+"]["+board[3][6]+"]["+board[3][7]+"] \n" +
				"["+board[4][0]+"]["+board[4][1]+"]["+board[4][2]+"]["+board[4][3]+"]["+board[4][4]+"]["+board[4][5]+"]["+board[4][6]+"]["+board[4][7]+"]["+board[4][8]+"] \n" +
				" ["+board[5][0]+"]["+board[5][1]+"]["+board[5][2]+"]["+board[5][3]+"]["+board[5][4]+"]["+board[5][5]+"]["+board[5][6]+"]["+board[5][7]+"] \n" +
				"  ["+board[6][0]+"]["+board[6][1]+"]["+board[6][2]+"]["+board[6][3]+"]["+board[6][4]+"]["+board[6][5]+"]["+board[6][6]+"] \n" +
				"   ["+board[7][0]+"]["+board[7][1]+"]["+board[7][2]+"]["+board[7][3]+"]["+board[7][4]+"]["+board[7][5]+"] \n" +
				"    ["+board[8][0]+"]["+board[8][1]+"]["+board[8][2]+"]["+board[8][3]+"]["+board[8][4]+"] \n" );
	}
}
