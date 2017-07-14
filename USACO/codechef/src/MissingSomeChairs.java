
import java.util.Scanner;


public class MissingSomeChairs {

	public static void main(String [] args){
		long a = 1000000007;
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i = 0; i < T; i++){
			long n = in.nextLong();
			System.out.println(modPow(2,n,a)-1);
		}
		
	}
	static long modPow(long a, long ex, long mod){
		if(ex == 0)
			return 1;
		if(ex == 1)
			return a%mod;
		
		if(ex % 2 == 0)
			return modPow((a%mod)*(a%mod)%mod, ex/2, mod)%mod;
		else 
			return (modPow(a, ex-1, mod)%mod) * (a%mod) % mod;
	}
}
