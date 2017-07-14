import java.util.Arrays;
import java.util.Scanner;

/*
4
1 0 0
1.005 0 0
0 0 0
0 0 0
3
1.2 .89
.88 5.1
1.1 0.15
4
3.1    0.0023    0.35
0.21   0.00353   8.13 
200    180.559   10.339
2.11   0.089     0.06111
2
2.0
0.45

 */
public class Arbitrage {

	static double[][][] conversions;
	static int [][][] path;
	static int [] sequence;
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		while(input.hasNext()){
			int CURR = input.nextInt();
			conversions = new double[CURR][CURR][CURR];
			path = new int[CURR][CURR][CURR];
			sequence = new int[CURR];
			//reading the file
			for(int i = 0; i < CURR; i++){
				for(int j = 0; j < CURR; j++){
					if(i == j){
						conversions[0][i][j] = 1.0;
					}else {
						conversions[0][i][j] = input.nextDouble();
					}
					path [0][i][j] = i;
				}
			}
			//modified floyd warshall algorithm
			for(int steps = 1; steps < CURR; steps++){
				for(int h = 0; h < CURR; h++){
					for(int i = 0; i < CURR; i ++){
						for(int j = 0 ; j < CURR; j++){
							//path through h
							double a = conversions[steps-1][i][h] * conversions[0][h][j];
							if(a > conversions[steps][i][j]){
								conversions[steps][i][j] = a;
								path[steps][i][j] = h;
							}
						}
					}
				}
			}
			//print(conversions);
			//print(path);
			int firstSolution = -1;
			for(int s = 0; s < CURR; s++){
				for(int i = 0; i < CURR; i ++){
					if(conversions[s][i][i] > 1.01){
						firstSolution = i;
						break;
					}
				}
				if(firstSolution != -1){
					 int outputSeq[] = new int[CURR+1] ; //for reverse sequnece because 4 transactions can have 5 parts
		             int index=0;
		 
		             int currentNo = firstSolution;
		             outputSeq[index++] = firstSolution;
		             for(int a = s; a >=0; -- a) { //path from targetNo to currentNo
		                 currentNo = path[a][firstSolution][currentNo];
		                 outputSeq[index++] = currentNo;
		             }
	            	 System.out.print(outputSeq[0]+1);
		             for(int i = s; i >= 0; i--){
		            	 System.out.print(" " + (outputSeq[i]+1));
		             }
	            	 System.out.println();
					break;
				}
			}
			if(firstSolution == -1)
				System.out.println("no arbitrage sequence exists");
			 
		}
	}
	static void print(double [][][] a){
		for(double [][] aa : a){
			for(double [] as :aa)
				System.out.println(Arrays.toString(as));
			System.out.println();
		}
	}
	static void print(int [][][] a){
		for(int [][] aa : a){
			for(int [] as :aa)
				System.out.println(Arrays.toString(as));
			System.out.println();
		}
	}
	

}

