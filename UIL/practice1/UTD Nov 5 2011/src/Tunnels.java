import java.util.Arrays;
import java.util.Scanner;


public class Tunnels {

	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		int N = in.nextInt(); // # of datasets
		for(int n = 0; n < N; n++){
			int P = in.nextInt(); // size of tunnels
			int pp2 = P * P; // p squared
			boolean [] safe = new boolean[pp2]; // we know our safe exits
			boolean [] blocked = new boolean[pp2]; // blocked intersections
			boolean [][] path = new boolean [pp2][pp2]; // intersections with known path
			int [][] distance = new int[pp2][pp2]; // distance known to intersections
			
			int nBlocked = in.nextInt(); // num of blocked squares
			for(int i = 0 ; i < nBlocked; i++){
				blocked[in.nextInt()-1] = true;
			}
			int nSafe = in.nextInt(); // num of blocked squares
			for(int i = 0 ; i < nSafe; i++){
				safe[in.nextInt()-1] = true;//so we know 
			}
			
			for(int i = 0; i < pp2; i++){
				int next = i + 1;
				if(next % P != 0 && !blocked [next]){
					distance[i][next] = 1000;
					path[i][next] = true;
				}
				int down = i + P;
				if(down < pp2 && !blocked [down]){
					distance[i][down] = 1000;
					path[i][down] = true;
				}
			}
			for(int h = 0; h < pp2; h++)
				for(int i = 0; i < pp2; i++){
					for(int j = 0; j < pp2; j++){
						if(!(blocked[i] || blocked[j] || blocked[h])){
							if(path [i][h] && path[h][j]){
								// there is no path from i - j or if there is but its longer
								if(!path[i][j] || ((distance[i][h] + distance[h][j] < distance[i][j]))){
									distance[i][j] = distance[i][h] + distance[h][j];
									path[i][j] = true;
								}
							}
						}
					}
				}
			int shortest = Integer.MAX_VALUE;// the shortest distance to safe hole
			for(int i = 0; i < pp2; i++){
				if(path[0][i])
					if(safe[i] && distance[0][i] < shortest){
						shortest = distance[0][i];
					}
			}
			if(shortest == Integer.MAX_VALUE){
				System.out.println("RATS!");
			}else {
				System.out.println(shortest);
			}
		}
	}
	public static void print(int [][] a){
		for(int [] as : a){
			System.out.println(Arrays.toString(as));
		}
	}
}
