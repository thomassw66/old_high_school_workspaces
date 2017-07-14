import java.util.Scanner;


public class CrossedLadders {

	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		while(in.hasNext()){
			double x = in.nextDouble();
			double y = in.nextDouble();
			double c = in.nextDouble();
			
			bsearch
			(x,y,c);
		}
	}
	static void bsearch(double x, double y, double c){

		double left = 0;
		double right = Math.min(x, y);
		double m = (left + right) / 2;
		while(left < right-1.0e-5){
			double h1 = Math.sqrt(x*x - m*m);
			double h2 = Math.sqrt(y*y - m*m);
			double c2 = f(h1,m,intersect(h1,h2,m));
			if(Math.abs(c2 - c) < 1.0e-5){ //c2 == c
				break;
			}else if(c2 < c - 1.0e-5){//c2 < c
				right = m;
			}else { //c2 > c
				left = m;
			}

			m = (left + right) / 2;
		}
		System.out.printf("%.3f\n",m);
	}
	static double f(double h1, double m, double x){
		return h1 - h1 / m * x;
	}
	static double intersect(double h1, double h2, double m){
		return h1*m / (h1+h2);
	}
}

