
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class CIRKILL {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		int T = in.nextInt();
		for(int i = 0; i < T; i++){
			int N = in.nextInt();
			Point2D [] points = new Point2D [N];
			for(int j = 0 ;j < N; j++){
				points[j] = new Point2D.Double(in.nextInt(), in.nextInt());
			}
			int totalWays = 0;
			int waysforashtodie = 0;

			for(int j = 0; j < N; j++){
				for(int k = j + 1; k < N; k++){
					for(int h = k + 1; h < N; h++){
						
						double a = distance(points[j],points[k]);
						double b = distance(points[k],points[h]);
						double c = distance(points[h],points[j]);
						

						Point2D bsjk = new Point2D.Double((points[j].getX() + points[k].getX()) / 2,(points[j].getY() + points[k].getY()) / 2);
						double m = (points[j].getY() - points[k].getY()) / (points[j].getX() - points[k].getX());
						Line2D l = makeLine(bsjk,-1/m);
						
					}
				}
			}
			System.out.println((double)waysforashtodie / (double)totalWays);
		}
	}
	static double distance(Point2D a,Point2D b){
		return distance(a.getX(), a.getY(), b.getX(), b.getY());
	}
	public static double distance(double x, double y, double x1, double y1){
		double dx = (x - x1);
		double dy = (y - y1);
		return Math.sqrt(dx*dx+dy*dy);
	}
	static Line2D makeLine(Point2D p, double m){
		if(!Double.isInfinite(m)){
			double yint = p.getY() - m*p.getX();
			double x = p.getX() + 1;
			double y = m * x + yint;
			Point2D p2 = new Point2D.Double(x,y);
			return new Line2D.Double(p,p2);
		}else {
			return new Line2D.Double(p,new Point2D.Double(p.getX(),p.getY()+1));
		}
	}
}
