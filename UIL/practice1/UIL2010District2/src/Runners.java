import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Runners {
	
	public static void main(String[] args) {

	}
	public static final int INF = Integer.MAX_VALUE;
	static int [][] cost;
	static char [][] map;
	public static void generatePaths(int x, int y){
		for(int i = 0; i < cost.length; i++){
			for(int j = 0; j < cost[i].length; j++){
				cost[i][j] = INF;
			}
		}
		Queue<Spot> q = new PriorityQueue<Spot>();
		q.add(new Spot(x,y,0));
		while(!q.isEmpty()){
			Spot s = q.remove();
			for(Spot next : s.getNeighBohrs()){
				if(next.cost < cost[next.x][next.y]){
					cost[next.x][next.y] = next.cost;
					q.add(next);
				}
			}
		}
	}
	public static boolean canMove(int x, int y){
		return x < map.length && x >= 0 && y < cost[x].length && y >= 0 && map[x][y] != '*';
	}
}
class Spot implements Comparable<Spot>{
	static final int [][]d = {{0,1},{0,-1},{1,1},{1,-1},{1,0},{-1,1},{-1,-1},{-1,0}};
	int x,y;
	int cost;
	public Spot(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	public List<Spot> getNeighBohrs(){
		ArrayList<Spot> n = new ArrayList<Spot>();
		for(int [] b : d){
			int nx = x + b[0];
			int ny = y + b[1];
			if(Runners.canMove(nx, ny)){
				n.add(new Spot(nx,ny,cost+1));
			}
		}
		return n;
	}
	public int compareTo(Spot arg0) {
		return this.cost - arg0.cost;
	}
}