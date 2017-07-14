
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class MiniMaxSolution {
	static final int M = Integer.MAX_VALUE, m = Integer.MIN_VALUE;
	int [] heuristic = {3,2,3,
						2,5,2,
						3,2,3};
	
	boolean equal(char ... a){
		char c = a[0];
		for(int i = 1; i < a.length; i++)
			if(c != a[i])return false;
		return true;
	}
	public int max(int [] vals){
		int max = m;
		int max_pos = -1;
		for(int i = 0; i < vals.length; i++){
			if(vals[i] > max){
				max = vals[i];
				max_pos = i;
			}
		}
		return max_pos;
	}
	public int min(int [] vals){
		int min = M;
		int min_pos = -1;
		for(int i = 0; i < vals.length; i++){
			if(vals[i] < min){
				min = vals[i];
				min_pos = i;
			}
		}
		return min_pos;
	}
	public boolean TERMINAL(char [] board){
		//full board
		boolean full = true;
		for(char a : board)
			if(a == '_')full = false;
		
		for(int i = 0; i < 3; i++){
			if(equal(board[i],board[i+3],board[i+6]) && (board[i] == 'X' || board[i]== 'O'))
				return true;
			if(equal(board[i*3],board[i*3 + 1],board[i*3 + 2]) && (board[i*3] == 'X' || board[i*3]== 'O'))
				return true;
		}
		if(equal(board[0],board[4],board[8])&& (board[0] == 'X' || board[0]== 'O'))
			return true;
		if(equal(board[2],board[4],board[6])&&(board[2] == 'X' || board[2]== 'O'))
			return true;
		return full;
	}	
	public char WINNER(char [] board){
		for(int i = 0; i < 3; i++){
			if(equal(board[i],board[i+3],board[i+6]) && (board[i] == 'X' || board[i]== 'O'))
				return board[i];
			if(equal(board[i*3],board[i*3 + 1],board[i*3 + 2]) && (board[i*3] == 'X' || board[i*3]== 'O'))
				return board[i*3];
		}
		if(equal(board[0],board[4],board[8])&& (board[0] == 'X' || board[0]== 'O'))
			return board[0];
		if(equal(board[2],board[4],board[6])&&(board[2] == 'X' || board[2]== 'O'))
			return board[2];
		return 0;
	}
	char not(char player){
		if(player == 'X')return 'O';
		else return 'X';
	}
	public int eval(char player, char [] board){

		if(TERMINAL(board))
		{
			char win = WINNER(board);	
			if(win == player)
				return 25;
			if(win == not(player))
				return -25;
			return 0;
		}else {
			int xSum = 0;
			int oSum = 0;
			for(int i = 0; i < board.length;i++){
				if(board[i] == 'X')
					xSum += heuristic[i];
				if(board[i] == 'O')
					oSum += heuristic[i];
			}
			return xSum - oSum;
		}
	}
	int MAX_VALUE(char player, char [] board){
		if(TERMINAL(board))
		{
			char win = WINNER(board);	
			if(win == player)
				return 1;
			if(win == not(player))
				return -1;
			return 0;
		}
		else
		{
			int [] values = {m,m,m,m,m,m,m,m,m};
			
			for(int i = 0; i < 9; i++)
			{
				if(board[i] == '_'){
					board[i] = player;
					values[i] = MIN_VALUE(player,board);
					board[i] = '_';
				}
			}
			int max = max(values);
			return values[max];
		}
	}
	private int MIN_VALUE(char player, char[] board) {
		if(TERMINAL(board))
		{
			char win = WINNER(board);	
			if(win == player)
				return 1;
			if(win == not(player))
				return -1;
			return 0;
		}
		else
		{
			int [] values = {M,M,M,M,M,M,M,M,M};
			for(int i = 0; i < 9; i++)
			{
				if(board[i] == '_'){
					board[i] = not(player);
					values[i] = MAX_VALUE(player,board);
					board[i] = '_';
				}
			}
			int min = min(values);
			return values[min];
		}
	}
	int move(char player, char [] board){
		int [] values = {m,m,m,m,m,m,m,m,m};
		int [] hValues = {m,m,m,m,m,m,m,m,m};
		
		for(int i = 0; i < 9; i++){
			if(board[i] == '_'){
				board[i] = player;
				values[i] = MIN_VALUE(player,board);
				hValues[i] = eval(player,board);
				board[i] = '_';
			}
		}
		int max = max(values);
		List a = new LinkedList();
		for(int i = 0; i < 9; i++){
			if(values[i] == values[max]){
				a.add(i);
			}
		}
		int max2 = (Integer)a.get(0);
		for(Object o : a){
			int b = (Integer)o;
			if(hValues[b] > hValues[max2])
				max2 = b;
		}
		System.out.println(Arrays.toString(values));
		System.out.println(Arrays.toString(hValues));
		System.out.println(max2 + " " + values[max2] + " " + hValues[max2]);
		return max2;
	}
	public char [] convert(String [] a){
		char [] board = new char[9];
		int i = 0;
		for(char c : a[0].toCharArray())
			board[i++] = c;
		for(char c : a[1].toCharArray())
			board[i++] = c;
		for(char c : a[2].toCharArray())
			board[i++] = c;
		return board;
	}
	public void nextMove(String player, String [] board){
		char [] board2 = convert(board);
		char player2 = player.charAt(0);
		int m = move(player2,board2);
		System.out.printf("%d %d\n", m / 3, m % 3);
	}
}
