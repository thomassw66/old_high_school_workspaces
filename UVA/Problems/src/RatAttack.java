import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class RatAttack {

	public static void main(String [] argssd){
		Scanner in = new Scanner (System.in);
		int scenarios = in.nextInt();
		
		for(int i = 0; i < scenarios; i++){
			int [][]damage = new int [1025][1025];
			int [][] rats = new int[1025][1025];
			
			int d = in.nextInt();
			// initialize rats
			int ratPops = in.nextInt();
			

			int mx = -1, my = -1;
			int max = Integer.MIN_VALUE;
			
			for(int ij = 0; ij < ratPops; ij++){
				int x = in.nextInt();
				int y = in.nextInt();
				int size = in.nextInt();
				rats[x][y] = size;

				for(int x2 = x - d; x2 <= x + d; x2++){
					for(int y2 = y - d; y2 <= y + d; y2++){
						if(y2 < 1025 && x2 < 1025 && x2 >= 0 && y2 >= 0){
							damage[x2][y2] += size;
							if(damage[x2][y2] > max){
								mx = x2;
								my = y2;
								max = damage[x2][y2];
							}
						}
					}
				}
			}
			System.out.println(mx + " " + my + " " + max);
		}
	}
}
