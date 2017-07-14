import java.util.Arrays;
import java.util.Scanner;


public class CuttingSticks {

	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		
		int L ;
		while((L = in.nextInt())!= 0){
			int c = in.nextInt();
			int [] cuts = new int[c+2];
			cuts[0] = 0;
			for(int i = 1; i < cuts.length -1; i++)
				cuts[i] = in.nextInt();
			cuts[c + 1] = L;
			
			int [][] best = new int [c+2][]; // best[j][i] holds the best cut from i to j 
			for(int i = 1; i < c+2; i++)
				best[i] = new int [i];
			
			for(int d = 2; ; d++){
				if(d >= c+2)break;
				for(int i = 0; i+d < c+2; i++ ){
					int min = Integer.MAX_VALUE;
					for(int j = i+1; j <= i+d -1; j++){
						if(best[j][i] + best[i+d][j] < min){
							min = best[j][i] + best[i+d][j];
						}
					}
					best[i+d][i] = cuts[i+d] - cuts[i] + min;
				}
			}
			//print(best);
			System.out.printf("The minimum cutting is %d.\n",best[c+1][0]);
		}
	}
	static void print(int [][] b){
		for(int [] a:b)
			System.out.println(Arrays.toString(a));
	}
}
