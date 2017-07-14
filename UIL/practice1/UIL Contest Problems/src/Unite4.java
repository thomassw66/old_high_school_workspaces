import java.io.File;
import java.util.Scanner;


public class Unite4 {
	public static void main(String [] welcome) throws Exception{
		Scanner input = new Scanner (new File("unite4.dat"));
		int games = input.nextInt(); input.nextLine();
		
		for(int i = 0; i < games; i ++){
			int pos[] = new int [7];
			char board [][] = new char [6][7];
			
			int moves = input.nextInt(); input.nextLine();
			boolean redTurn = true;
			for(int j = 0; j < moves; j ++){
				int row = input.nextInt() - 1;
				
				//add to board
				//System.out.println(row);
				board[board.length - (++pos[row])][row] = (redTurn ? 'R' : 'B');
				redTurn = !redTurn;
			}
			input.nextLine();
			print(board);
			if(hasWon('R',board)){
				System.out.println("RED WINS");
			}else if(hasWon('B',board)){
				System.out.println("BLACK WINS");
			}else {
				System.out.println("NO WINNER YET");
			}
		}
	}
	static boolean hasWon (char c, char [][] board){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == c){
					//we can look to the side
					if(board[i].length - j > 4 && board.length - i > 4){
						System.out.println("ok");
						if(board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2] && board[i][j] == board[i+3][j+3] && board[i][j] == board[i+4][j+4]){
							return true;
						}
					}
					else if(board.length - i > 4){
						System.out.println("ok");

						if(board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j] && board[i][j] == board[i+4][j]){
							return true;
						}
					}
					else if(board[i].length - j > 4){
						System.out.println("ok");

						if(board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3] && board[i][j] == board[i][j+4]){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	static void print(char [][] a){
		System.out.println(" 1234567");
		for(int i = 1; i <= 6; i ++){
			System.out.print(i);
			for(int j = 1; j <= 7; j++){
				if(a[i-1][j-1] != 'R'&&a[i-1][j-1] != 'B')
					System.out.print("O");
				else 
					System.out.print(a[i-1][j-1]);
			}
			System.out.println();
		}
	}
}
