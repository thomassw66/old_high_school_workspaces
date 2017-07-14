import java.util.Scanner;


public class NUMFACT {

	public static void main(String [] args){
		boolean [] seive = new boolean[1000001];
		int [] primes = new int[78498];
		int pcount = 0;
		for(int i = 2; i < seive.length; i++){
			if(!seive[i]){
				//System.out.println(i);
				primes[pcount++] = i;
				for(int m = i + i; m <= 1000000; m += i){
					seive[m] = true;
				}
			}
		}
		Scanner in = new Scanner (System.in);
		int T = in.nextInt();
		for(int t = 0; t < T; t++){
			int [] tdiv = new int [78498];
			int n = in.nextInt();
			int prod = 1;
			for(int i = 0; i < n; i++){
				int a = in.nextInt();
				int p = 0;
				while(a > 1){
					while(a % primes[p] == 0){
						a /= primes[p];
						tdiv[p]++;
					}
					p++;
				}
			}
			for(int i = 0; i < tdiv.length; i++){
				prod *= (tdiv[i]+1);
			}
			System.out.println(prod);
		}
	}
}
