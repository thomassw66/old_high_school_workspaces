import java.util.Scanner;


public class SolveIt {
	static int p, q, r, s, t, u; 
	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		while(in.hasNext()){
			p = in.nextInt();
			q = in.nextInt();
			r = in.nextInt();
			s = in.nextInt();
			t = in.nextInt();
			u = in.nextInt();
			double x = solver();
			if(x == -1){
				System.out.println("No solution");
			}else {
				System.out.printf("%.4f\n",x);
			}
		}
	}
	static double solver(){
		double lo = 0;
		double hi = 1;
		if(f(lo)*f(hi) <= 0){
			while(hi - lo > 1e-9){
				double mid = (lo + hi) / 2.0;
				if(f(mid)*f(lo) <= 0){
					hi = mid;
				}else {
					lo = mid;
				}
			}
			return lo;
		}
		return -1;
	}
	static double f(double x){
		return p*Math.exp(-x)+ q*Math.sin(x) + r*Math.cos(x) + s*Math.tan(x) + t*x*x + u;
	}
}
