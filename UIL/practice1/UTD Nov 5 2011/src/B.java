import java.util.Scanner;


public class B {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int s = in.nextInt(); // # of cases
		for(int i = 0 ; i < s; i++){
			double x= in.nextDouble(),y=in.nextDouble(),v=in.nextDouble(),p=in.nextDouble();
			double xp2 = x*x, yp2 = y*y, vp2 = v*v, pp2 = p*p;
			double b = 2 * x * v;
			double c = xp2 + yp2;
			double a = vp2 - pp2;
			double t = (-b - Math.sqrt(b*b - 4 * a * c))/(2*a);
			double t2 = (-b - Math.sqrt(b*b - 4 * a * c))/(2*a);
			if(t < 0)
				System.out.printf("%.2f",t2);
			else
				if(t2 < 0)
					System.out.printf("%.2f",t2);
				else
					//neither are less than zero
					System.out.printf("%.2f",Math.min(t, t2));
			System.out.println();
		}
		
	}

}
