import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

/* Complete the function below to print 2 integers separated by a single space which will be your next move */
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
	public static void findWinning(char player,char [][] board){
		int winner = whoWon(board);	
		if(winner == player){
			wins+=2;
			//System.out.println("Winning board!");
			//printBoard(board);
			return;
		}
		if(winner == 0){
			for(int x = 0; x < 3; x++){
				for(int y = 0; y < 3; y++){
					if(board[x][y] != 'X' && board[x][y] != 'O' ){
						
						board[x][y] = (player == 'X'? 'O': 'X');
						
						if(whoWon(board) != 0){
							losses+=2;
							//System.out.println("Losing Board!");
							//printBoard(board);
						}else {
							//printBoard(board);
							for(int i = 0; i < 3; i++){
								for(int j = 0; j < 3; j++){
									if(board[i][j] != 'X' && board[i][j] != 'O' ){
										board[i][j] = player;
										findWinning(player,board);
										//System.out.println("^");
										board[i][j] = '_';
									}
								}
							}
						}
						board[x][y] = '_';
					}
				}
			}
		}
	}
	public static void nextMove(char player, char [][]board){
		int bestScore = Integer.MIN_VALUE, mi = 0, mj = 0;
		boolean found = false;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] != 'X' && board[i][j] != 'O'){
					
					board[i][j] = player;
					//in case we find an Immediate Solution
					if(whoWon(board) == player){
						mi = i; 
						mj = j;
						found = true;
					}else {
						wins = losses = 0;
						findWinning(player, board);
						int score = wins - losses;
						if(score > bestScore){
							bestScore = score;
							mi = i; 
							mj = j;
						}
					}
					board[i][j] = '_';
				}
				if(found) break;
			}
			if(found) break;
		}

		System.out.println(mi+" "+mj);
	}
    static void nextMove(String player, String [] board){
        char p = player.charAt(0);
        char b[][] = {
                board[0].toCharArray(),
                board[1].toCharArray(),
                board[2].toCharArray()
        };
        nextMove(p,b);
    }
  
  public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String player;
        String board[] = new String[3];

        //If player is X, I'm the first player.
        //If player is O, I'm the second player.
        player = in.next();

        //Read the board now. The board is a 3x3 array filled with X, O or _.
        for(int i = 0; i < 3; i++) {
            board[i] = in.next();
        }

  		nextMove(player,board);	
    
    }
}
