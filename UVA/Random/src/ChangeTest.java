import java.util.Arrays;


public class ChangeTest {

	static int [] costumerchange = new int [501];
	static int [] denom = {5,10,20,50,100,200};
	static int [] costumercount = {10, 10, 10, 10, 10, 10};
	static int [][] used = new int [501][6];
	public static void main(String [] args){
		for(int i = 0; i < 501; i++){
			costumerchange[i] = 1000000;
		}
		for(int i = 0; i < costumercount[0]; i++){
			for(int j = 0; j < costumercount[1]; j++){
				for(int k = 0; k < costumercount[2]; k++){
					for(int l = 0; l < costumercount[3]; l++){
						for(int m = 0; m < costumercount[4]; m++){
							for(int n = 0; n < costumercount[5]; n++){
								int s = i * denom[0] + j * denom[1] + k *denom[2] + 
										l * denom[3] + m * denom[4] + n * denom[5];
								if(s <= 500){
									costumerchange[s] = Math.min(costumerchange[s], i+j+k+l+m+n);
								}
							}
						}	
					}	
				}
			}
		}
		for(int i = 0; i < 501; i += 5)
			System.out.println(i + " " + costumerchange[i]);
	}
	
}
