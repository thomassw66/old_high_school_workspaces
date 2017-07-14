import java.util.Scanner;


public class MineSweeper {
	
	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		int games = Integer.parseInt(in.nextLine());
		for(int game = 0; game < games; game++){

			in.nextLine();
			int n = Integer.parseInt(in.nextLine());
			
			int [][] board = new int[n][n];
			boolean [][] clicked = new boolean[n][n];
			boolean boom = false;
			
			for(int i = 0; i < n; i++){
				String s = in.nextLine();
				for(int j = 0; j < n; j++)
					if(s.charAt(j) == '*') board[i][j] = -1;
			}
			for(int i = 0; i < n; i++){
				String s = in.nextLine();
				for(int j = 0; j < n; j++)
					if(s.charAt(j) == 'x'){ 
						clicked[i][j] = true;
						if(board[i][j] == -1)
							boom = true;
					}
			}
			for(int i = 0 ; i < n; i++){
				for(int j = 0;j < n; j++){
					if(!(board[i][j] == -1)){
						int sum = 0;
						for(int a : new int[]{-1, 0, 1}){
							for(int b : new int[]{-1, 0, 1}){
								int ni = i + a;
								int nj = j + b;
								if(a == 0 && b == 0)continue;
								if(in(ni,nj,n)){
									if(board[ni][nj] == -1){
										sum ++;
									}
								}
							}
						}
						board[i][j] = sum;
					}
				}
			}
			//print 
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(clicked[i][j]){
						if(board[i][j] == -1){
							System.out.print("*");
						}else {
							System.out.print(board[i][j]);
						}
					}else {
						if(boom && board[i][j] == -1){
							System.out.print("*");
						}else 
							System.out.print(".");
					}
				}
				System.out.println();
			}
			if(game < games-1)
				System.out.println();
		}
	}
	static boolean in(int row, int col,int n){
		return row >= 0 && col >= 0 && row < n && col < n;
	}
}
