import java.util.Arrays;
import java.util.Scanner;


public class CharmichalNums {
	static boolean [] composite = new boolean[65000];
	public static void generateSieve(boolean [] b){
		int i = 2;
		int max = (int)Math.sqrt(b.length) + 1;
		while(i < max){
			//till we find the next prime
			while(b[i])
				i++;
			
			int n = i << 1;
			while(n < b.length){
				b[n] = true;
				n += i;
			}
			
			i++;
		}
	}
	public static long apnmn(long a, long n){
		long p = a;
		for(int i = 1; i < n; i++){
			p *= a;
			p %= n;
		}
		return p;
	}
	static boolean cTest(int n){
		if(!composite[n])
				return false;
		for(int i = 2; i < n; i++){
			if(i != apnmn(i,n)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		//generateSieve(composite);

		
		int [] cns = {561,1105,	1729,2465,2821,	6601,8911,10585,15841,29341,41041,46657,52633,62745,63973};

		Scanner in = new Scanner(System.in);
		int n;
		while((n = in.nextInt()) != 0){
			if(Arrays.binarySearch(cns, n) >= 0){
				System.out.printf("The number %d is a Charmichael number.\n",n);
			}else {
				System.out.printf("%d is normal.\n",n);
			}
		}
	}

}
