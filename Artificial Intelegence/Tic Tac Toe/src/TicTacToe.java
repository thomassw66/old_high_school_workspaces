
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TicTacToe {
	static int wins;
	static int losses;
	/*
	 * whoWon : board
	 * 
	 * finds the winner of a tic tac toe board, with players X and O
	 * assuming there is only one,
	 * 
	 * returns 0 if no one wins
	 * returns X or O if they win
	 */
	public static char whoWon(char [][] board){
		for(int i = 0; i < 3; i++){
			if(equal(board[0][i],board[1][i],board[2][i]) && (board[0][i] == 'X' || board[0][i] == 'O'))
				return board[0][i];
			if(equal(board[i][0],board[i][1],board[i][2]) && (board[i][0] == 'X' || board[i][0] == 'O'))
				return board[0][i];
		}
		if(equal(board[0][0],board[1][1],board[2][2]) && (board[0][0] == 'X' || board[0][0] == 'O'))
			return board[0][0];
		if(equal(board[0][2],board[1][1],board[2][0]) && (board[0][2] == 'X' || board[0][2] == 'O'))
			return board[0][2];
		return 0;
	}
	
	public static boolean equal(char...cs){
		char c = cs[0];
		for(int i = 1; i < cs.length; i++)
			if(c != cs[i])
				return false;
		return true;
	}
	public static void printBoard(char b[][]){
		System.out.println("--------");
		for(int i = 0; i < 3; i++){
			System.out.println(Arrays.toString(b[i]));
		}
	}
	static void findFirst(char player,char [][] board){
		
	}
	public static void nextMove(char player, char [][]board){
	}
}
