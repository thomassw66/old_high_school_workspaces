
public class BigFloodFill {

	static char [][] grid = {{'s', 's','s','*','s','s','s','*','s', 's','s'},
							{'s', 's','s', 's','s','s','s','s','s', 's','s'},
							{'s', 's','s', 's','s','s','s','s','s', 's','s'},
							{'s', 's','s', 's','s','*','s','s','s', 's','s'},
							{'s', 's','s', 's','s','s','s','s','s', 's','s'},
							{'s', 's','s', 's','s','s','s','s','s', 's','s'}};
	public static void main(String[] args) {

	}
	static boolean in(int x, int y){
		return (x >= 0 && x < grid.length)&&(y >= 0 && y < grid[x].length);
	}
	static boolean canBeIn(int x, int y){
		if(in(x,y)){
			for(int dx= 0; dx < 3; dx++){
				for(int dy = 0; dy < 3; dy++){
					int nx = x + dx, ny = y + dy;
					if(in(nx,ny)){
						if(grid[nx][ny] != '*')
							continue;
					}
					return false;
				}
			}
			return true;
		}
		return false;
	}
	void flood(int x, int y){
		
	}
}
