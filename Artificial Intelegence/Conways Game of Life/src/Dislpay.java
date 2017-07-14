import java.io.IOException;
import java.util.Scanner;


public class Dislpay {
	static final int [][] delta = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0,1},{1,1}};
	
	public static void main(String [] arg) throws Exception{
		char [][] board = readGrid();
		
		while(true){
			System.out.println("______________________________");
			display(board);
			board = TURN(board);
			Thread.sleep(100);
		}
	}
	static char [][] readGrid(){
		Scanner kb = new Scanner (System.in);
		int s = Integer.parseInt(kb.nextLine());
		char [][] b = new char[s][];
		for(int i = 0; i < s; i++)
			b[i] = kb.nextLine().toCharArray();
		return b;
	}
	static void display(char [][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	static boolean inBounds(int x, int y, char [][] board){
		return (x < board.length && x >= 0 && y < board[x].length && y >= 0);
	}
	static int GET_SURROUNDING_LIVING(int x, int y ,char [][] board){
		int i = 0;
		for(int [] d : delta){
			int nx = x + d[0];
			int ny = y + d[1];
			if(inBounds(nx,ny,board)){
				if(board[nx][ny] == 'X')
					i++;
			}
		}
		return i;
	}
	static char [][] TURN(char [][] board){
		char [][] newBoard = new char [board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length;j++){
				
				int a = GET_SURROUNDING_LIVING(i,j,board);
				newBoard[i][j] = board[i][j];
				if(a == 3)
					newBoard[i][j] = 'X';
				else if(a < 2 || a > 3)
					newBoard[i][j] = '-';
			}
		}
		return newBoard;
	}
}
/*29
-----------------------------
XXXX-------------------------
XXXX-------------------------
-----------------------------
-----------------------------
----XXXX---------------------
------XXXXX----------------X-
--------------------------XXX
-----------------------------
-----------------------------
-----XXXXXXX-----------------
-----------------------------
-----------------------------
-----------------XXX---------
--------XXX------------------
-----------------------------
-----------------------------
-----------------------------
-----------------------------
------------XXXX-------------
--------------XXXX-----------
----------------XXXX---------
------------------XXXXX------
-----------------------------
-----------------------------
-----------------------------
-----X-X-------------X-------
------XX------------XXX------
------X----------------------
-----------------------------
*/
