import java.util.Arrays;


public class Amazing {

	static final int[] NORTH = {0,-1} , EAST = {-1,0}, WEST = {1,0}, SOUTH = {0,1};//positive is down
	static final int [][] dirs = {NORTH, WEST, SOUTH, EAST};
	static final int N=0,W=1,S=2,E=3;
	static char [][] wall;

	static void runMaze(int x,int y,int[] south2, int count){
		int [][] around = nDirs(x,y);
		if(wall[around[S][0]][around[S][1]] == 0){}
	}
	static int [][] nDirs(int x, int y){
		int [][] s = {{x+NORTH[0],y+NORTH[1]},{x+EAST[0],y+EAST[1]},{x+WEST[0],y+WEST[1]},{x+SOUTH[0],y+SOUTH[1]}};
		return s;
	}
	public static void main(String [] args){
		runMaze(10,10,SOUTH,0);
	}
}
