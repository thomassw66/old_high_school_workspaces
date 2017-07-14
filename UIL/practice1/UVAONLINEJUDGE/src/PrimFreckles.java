import java.util.Scanner;


public class PrimFreckles {
	static final double INF = Double.MAX_VALUE;
	static double weights[][];
	static int N;
	public static void main(String [] atgs){
		Scanner in = new Scanner (System.in);
		int c = in.nextInt();
		for(int i = 0; i < c; i++){
			N = in.nextInt();
			double [][] points = new double [N][2];
			weights = new double[N][N];
			for(int j = 0; j < N; j++){
				points[j][0] = in.nextDouble();
				points[j][1] = in.nextDouble();
			}
			for(int x = 0; x < N; x++){
				for(int y = 0; y < N; y ++){
					weights[x][y] = distance(points[x],points[y]);
				}
			}
			System.out.printf("%.2f\n",prim());
			System.out.println();
		}
	}
	static double distance(double [] p1, double [] p2){
		double xd = p1[0] - p2[0];
		double yd = p1[1] - p2[1];
		return Math.sqrt(xd * xd + yd * yd);
	}
	public static double prim(){
		boolean used[] = new boolean[N];
		double dist[] = new double [N];
		
		for(int i = 0; i < N; i++){
			used[i] = false;
			dist[i] = INF;
		}
		int v = 0;
		dist[v] = 0;
		
		while(!used[v]){
			used[v] = true;
			for(int i = 0; i < N; i++){
				double w = weights[v][i];
				if(!used[i] && w < dist[i]){
					dist[i] = w;
				}
			}
			
			//choose the minimum availible
			double min_dist = INF;
			for(int i = 0; i < N; i++){
				if(!used[i] && min_dist > dist[i]){
					min_dist = dist[i];
					v = i;
				}
			}
		}
		return sum(dist);
	}
	static double sum(double[]a){
		double d = 0;
		for(double s: a){
			d += s;
		}
		return d;
	}
}
