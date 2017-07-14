import java.util.Scanner;


public class Billiards {

	public static void main(String[] args){
		Scanner in = new Scanner (System.in);
		while(true){
			double a = in.nextInt();
			double b = in.nextInt();
			double s = in.nextInt();//seconds
			double m = in.nextInt();
			double n = in.nextInt();
			if(s <= 0)break;
			double dist2 = n*b*n*b + a*m*a*m;
			double distance = Math.sqrt((double) dist2);
			//System.out.println(dist2);
			double speed = distance / s;
			double tan =  (b*n) / (a*m);
			double theta = Math.toDegrees(Math.atan(tan));
			System.out.printf("%.2f %.2f\n", theta,speed);
		}
	}
}
