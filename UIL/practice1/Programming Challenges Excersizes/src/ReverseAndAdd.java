import java.util.Scanner;


public class ReverseAndAdd {
	public static void main(String [] as){
		Scanner in = new Scanner (System.in);
		int c = in.nextInt(); // number of cases 
		for(int i = 0; i < c; i++){
			long x = in.nextLong();
			int its = 0; // number of iterations
			long xrv; // x reverswed
			while(x != (xrv = reverse(x))){
				x += xrv;
				its++;
			}
			System.out.println(its + " " + x);
		}
	}
	static long reverse(long a){
		long t = 0;
		while(a > 0){
			t *= 10;
			long d = a % 10;
			a /= 10;
			t += d;
		}
		return t;
	}
}
