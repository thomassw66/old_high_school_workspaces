import java.util.Scanner;


public class ReverseThenAdd {

	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++){
			long input = in.nextInt();
			int j;
			for(j = 0;;){
				input = rev(input) + input;
				j++;
				if(isPal(input))break;
			}
			System.out.printf("%d %d\n",j, input);
		}
	}
	static long rev(long n){
		long res = 0;
		while(n > 0){
			res *= 10;
			res += n % 10;
			n /= 10;
		}
		return res;
	}
	static boolean isPal(long a){
		return a == rev(a);
	}
}
