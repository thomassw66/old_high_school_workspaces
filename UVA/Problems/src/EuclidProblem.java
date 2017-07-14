import java.util.Scanner;


public class EuclidProblem {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			long g = gcd(in.nextLong(),in.nextLong());
			System.out.println(x + " " + y + " " + g);
		}
	}
	static long x,y;
	static long gcd(long p,long q){
		
		if(q == 0){
			x = 1;
			y = 0;
			return p;
		}
		
		long g = gcd(q, p % q);
		
		long t = x;
		x = y;
		y = (t - p/q*y);
		return g;
	}
}
