
public class RegularFlood {

	static int [][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static char [][] map = {
			{'A','A','B','A','A','A','A','A','A'},
			{'A','A','B','A','A','A','A','A','A'},
			{'A','B','B','B','B','A','A','A','A'},
			{'A','B','A','A','B','A','A','A','A'},
			{'A','B','A','A','B','A','A','A','A'},
			{'A','B','A','B','B','A','A','A','A'}};
	static int [][] been;
	static int HEIGHT;
	static int WIDTH;
	public static void main(String [] artsadfna)
	{
		WIDTH = map.length;
		HEIGHT = map[0].length;
		been = new int[WIDTH][HEIGHT];
		
		int hoods = 1;
		for(int i = 0; i < WIDTH; i++){
			for(int j =0; j < HEIGHT; j++){
				if(been [i][j] == 0){
					System.out.println(floodWrap(i,j,hoods));
				}
			}
		}
	}
	public static int flood(int x,int y,int hoodNumber){
		been[x][y] = hoodNumber;
		int tot = 1;
		for(int i = 0; i < delta.length; i ++){
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			if(in(nx,ny) && map[nx][ny] == map[x][y] && been[nx][ny] == 0){
				tot += flood(nx,ny,hoodNumber);
			}
		}
		return tot;
	}
	public static int floodWrap(int x,int y,int hoodNumber){
		been[x][y] = hoodNumber;
		int tot = 1;
		for(int i = 0; i < delta.length; i ++){
			int nx = ((x + delta[i][0]) + WIDTH ) % WIDTH;
			int ny = ((y + delta[i][1])+ HEIGHT ) % HEIGHT;
			if(in(nx,ny) && map[nx][ny] == map[x][y] && been[nx][ny] == 0){
				tot += floodWrap(nx,ny,hoodNumber);
			}
		}
		return tot;
	}
	static boolean in(int x,int y){
		return x < WIDTH && x >=0 && y < HEIGHT && y >=0;
	}
}
