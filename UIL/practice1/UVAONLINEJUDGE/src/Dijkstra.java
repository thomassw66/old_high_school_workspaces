import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;



public class Dijkstra {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int nNodes = in.nextInt();
		GNode [] nodes = new GNode[nNodes];
		for(int i = 0; i < nNodes; i++)
			nodes[i] = new GNode();
		int nEdges = in.nextInt();
		for(int i = 0 ; i < nEdges; i++){
			int f = in.nextInt();
			int t = in.nextInt();
			int w = in.nextInt();
			nodes[f].addPath(nodes[t], w);ikj
		}
		shortest_path(nodes[0]);
		System.out.println(Arrays.toString(nodes));
	}
	
	public static void shortest_path(GNode start){
		Queue<GNode> Q = new PriorityQueue<GNode>();
		Q.add(start);
		start.cost = 0;
		while(!Q.isEmpty()){
			GNode vertex = Q.poll();
			vertex.processed = true;
			int c = vertex.cost;
			for(int i = 0; i < vertex.paths.size(); i++){
				GNode n = vertex.paths.get(i);
				if(!n.processed){
					int w = vertex.weights.get(i);
					if(n.cost > w + c){
						n.cost = w + c;
						n.parent = vertex;
					}
					Q.add(n);
				}
			}
		}
	}
}
class GNode implements Comparable<GNode>{
	static final int INF = Integer.MAX_VALUE;
	List<GNode> paths;
	List<Integer> weights;
	int cost;
	GNode parent;
	boolean processed;
	public GNode(){
		cost = INF;
		processed = false;
		parent = null;
		paths = new ArrayList<GNode>();
		weights = new ArrayList<Integer>();
	}
	public void addPath(GNode n, int w){
		paths.add(n);
		weights.add(w);
	}
	public int compareTo(GNode arg0) {
		return cost - arg0.cost;
	}
	public String toString(){
		return Integer.toString(cost);
	}
}