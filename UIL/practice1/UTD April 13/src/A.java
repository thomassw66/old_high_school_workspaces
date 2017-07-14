
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int n = Integer.parseInt(in.nextLine());
		for(int i = 0; i < n; i++){
			boolean [][] grid = new boolean [3][3];
			String a = in.nextLine();
			String b = in.nextLine();
			String c = in.nextLine();
			for(int j = 0; j < 3; j++){
				grid[0][j] = a.charAt(j) == '*';
				grid[1][j] = b.charAt(j) == '*';
				grid[2][j] = c.charAt(j) == '*';
			}
			System.out.println(function(grid,0,0));
		}
	}
	public static int function(boolean [][] a, int depth, int clicksSoFar){
		if(isBlank(a))return clicksSoFar;
		if(depth > 8) return -1;
		int withClick = function(click(a,depth),depth+1,clicksSoFar+1);
		int noClick = function(a,depth+1,clicksSoFar);
		if(noClick == -1)
			return withClick;
		return noClick;
	}
	static boolean isBlank(boolean [][] a){
		boolean boo = false;
		for(boolean [] b : a)
			for(boolean c : b)
				boo = boo || c;
		return !boo;
	}
		
	public static boolean check(int x, int y){
		return x >= 0 && x < 3 && y >= 0 && y < 3;
	}
	public static void change(boolean [][] a , int x, int y){
		if(check(x,y))
			a[x][y] = !a[x][y];
	}
	public static boolean [][] click(boolean [][] a, int pos){
		boolean [][] result = new boolean [3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				result[i][j] = a[i][j];
		int y = pos % 3;
		int x = pos / 3;
		change(result,x,y);
		change(result,x+1,y);
		change(result,x-1,y);
		change(result,x,y+1);
		change(result,x,y-1);
		return result;
	}
}
