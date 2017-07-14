import java.util.ArrayList;
import java.util.Scanner;

public class SlimSpan {
	
	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		while(true){
			int n = in.nextInt();
			int m = in.nextInt(); 
			if(n == 0 && m == 0)break;
			
			ArrayList<Integer> [] distances = new ArrayList[n];
			ArrayList<Integer> [] vertex = new ArrayList[n];
			
			for(int i = 0; i < n; i++){
				distances[i] = new ArrayList<Integer>(n);
				vertex[i] = new ArrayList<Integer>(n);
			}
			for(int i = 0; i < m; i++){
				int a = in.nextInt() - 1;
				int b = in.nextInt() - 1;
				int w = in.nextInt();
				distances[a].add(w);
				vertex[a].add(b);
				distances[b].add(w);
				vertex[b].add(a);
			}
			int c = modprims(0,vertex,distances);
			System.out.println(c == Integer.MAX_VALUE? -1 : c);
		}
	}
	static int modprims(int start, ArrayList<Integer>[] vertex, ArrayList<Integer>[] distances){
		int m = Integer.MAX_VALUE;
		for (int e = 0; e < vertex[start].size(); e++){
			int b = distances[start].get(e);
			int s = b;
			boolean [] intree = new boolean [vertex.length];
			intree[start] = true;
			intree[vertex[start].get(e)] = true;
			
			int cost;
			int d = b;
			int v = start;
			while(v >= 0){
				intree[v] = true;
				b = Math.max(b, d);
				s = Math.min(s, d);
				
				cost = Integer.MAX_VALUE;
				d = -1;
				v = -1;
				for (int i = 0; i < intree.length; i++){
					if(intree[i] == true){
						for(int j = 0; j < vertex[i].size(); j++){
							int v_ = vertex[i].get(j);
							if(intree[v_] == false){
								int dist = distances[i].get(j);
								if(cost(b,s,dist) < cost){
									cost = cost(b,s,dist);
									d = dist;
									v = v_;
								}
							}
						}
					}
				}
			}
			if (istrue(intree)){
				if(b - s < m)
					m = b - s;
			}
		}
		return m;
	}
	static int cost(int max, int min, int c){
		if(c <= max && c >= min)
			return 0;
		else 
			return Math.min(Math.abs(c - max),Math.abs(c - min));
	}
	static boolean istrue(boolean[]a){
		boolean c = true;
		for(boolean b : a){
			c &= b;
		}
		return c;
	}
}
