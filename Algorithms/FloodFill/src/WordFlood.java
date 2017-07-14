
public class WordFlood {
	static int WIDTH;
	static int HIEGHT;
	static boolean [][] been 
	;
	static char [][] board = {
			{'A','B','I','N'},
			{'A','B','A','G'},
			{'A','B','O','S'},
			{'D','R','A','T'}};
	static int [][] delta = {{1,1},{1,0},{1,-1},{-1,1},{-1,0},{-1,-1},{0,1},{0,-1}};
	public static void main(String[] asef){
		WIDTH = board.length;
		HIEGHT = board[0].length;
		System.out.println(isWordOnBoard("DRATS"));
	}
	public static boolean isWordOnBoard(String s){
		been = new boolean [WIDTH][HIEGHT];
		
		char c = s.charAt(0);
		
		for(int i=0; i<WIDTH; i++ ){
			for(int j = 0 ; j < HIEGHT; j++){
				if(board[i][j] == c){
					if(floodSearch(i,j,s,1))
						return true;
					
					been[i][j] = false;
				}
			}
		}
		return false;
	}
	static boolean floodSearch(int x,int y, String s, int index){
		if(index >= s.length()){
			been[x][y] = false;
			return true;
		}
		been [x][y] = true;
		for(int i = 0; i < delta.length; i++){
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			
			if(		//were not out of bounds
					in(nx,ny) && 
					//and we havent been at the new spot
					!been[nx][ny] && 
					//and its what were looking for
					board[nx][ny] == s.charAt(index)		
			){
				
				boolean b = floodSearch(nx,ny,s,index+1);
				
				if(b){
					been[x][y] = false;
					return true;
				}
			}
		}

		been [x][y] = false;
		return false;
	}
	static boolean in(int x,int y){
		return x < WIDTH && x >= 0 && y < HIEGHT && y >= 0;
	}
}
