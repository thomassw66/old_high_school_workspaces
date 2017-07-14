import java.awt.Point;
import java.util.Scanner;


public class G {

	/**
	 * Squares
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int points;
		while((points = in.nextInt()) != 0){
			
		}

	}

}
class Rectangle{
	double rightX,leftX,topY,bottomY;
	public Rectangle(Point center,double sideLength){
		rightX = center.x + sideLength;
		leftX = center.x - sideLength;
		topY = center.y + sideLength;
		bottomY = center.y - sideLength;
	}
	boolean in(double x, double y){
		return x > leftX && x < rightX && y > bottomY && y < topY;
	}
	static boolean intersect(Rectangle a, Rectangle b){
		return a.in(b.leftX,b.topY) || a.in(b.rightX,b.topY) || a.in(b.leftX,b.bottomY) || a.in(b.rightX,b.bottomY);
	}
}