import java.util.Arrays;
import java.util.Scanner;


public class MakingChange {

	static int costumercount[] = new int [6];
	static int denom[] = {5,10,20,50,100,200};
	static int makechange [] = new int [501]; // how well cashier can make change
	static int costumerchange []= new int [501];
	static int used [][] = new int [501][6];
	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		
		for(int i = 5; i <= 500; i+=5 )
			for(int j = denom.length-1; j >= 0; j--)
				if(i >= denom[j]){
					makechange[i] = 1 + makechange[i - denom[j]];
					break;
				}
		
		while(true){
			boolean qflag = true;
			for(int i = 0; i < costumercount.length; i++)
			{
				costumercount[i] = in.nextInt();
				qflag &= (costumercount[i] == 0);
			}
			if(qflag)break;			

			int [][] count = new int [501][6];
			
			int change =(int)(Math.round(in.nextDouble() * 100));
			//System.out.println(change);
			
			for(int i = 0; i < 501; i++){
				costumerchange[i] = 1000000;
			}
			for(int i = 0; i <= costumercount[0]; i++){
				for(int j = 0; j <= costumercount[1]; j++){
					for(int k = 0; k <= costumercount[2]; k++){
						for(int l = 0; l <= costumercount[3]; l++){
							for(int m = 0; m <= costumercount[4]; m++){
								for(int n = 0; n <= costumercount[5]; n++){
									int s = i * denom[0] + j * denom[1] + k *denom[2] + 
											l * denom[3] + m * denom[4] + n * denom[5];
									//if(s == 400)System.out.println(i+","+j+","+k+","+l+","+m+","+n);
									
									if(s <= 500){
										costumerchange[s] = Math.min(costumerchange[s], i+j+k+l+m+n);
									}
								}
							}	
						}	
					}
				}
			}
			
			/*for(int i = 0; i <= 500; i += 5){
				System.out.println(i+ " " + costumerchange[i]);
			}*/
			//System.out.println(400 + "[" + costumerchange[400] +"]" );
			
			int best= Integer.MAX_VALUE;
			for(int i = change; i <= 500; i+=5){
				//if(costumerchange[i] == 0)continue;
				int c = i - change;
				//System.out.println(i + "[" + costumerchange[i] +"],  " + c + "["+ makechange[c] +"]");
				if(costumerchange[i] + makechange[c] < best)
					best = costumerchange[i] + makechange[c];
			}
			System.out.printf("%3d\n", best);
		}
	}
}
