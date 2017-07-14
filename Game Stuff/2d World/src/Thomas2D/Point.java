package Thomas2D;

public class Point extends Tuple{
	
	public Point(double x, double y) {
		super(x, y);
	}
	public static double distanceSquared(Point p, Point a){
		return (p.getX() - a.getX()) * (p.getX() - a.getX()) + (p.getY() - a.getY())*(p.getY() - a.getY());
	}
	public static double distance(Point p, Point a){
		return Math.sqrt(distanceSquared(p,a));
	}
	public void translate(Vector v){
		this.setX(this.getX() + v.getX());
		this.setY(this.getY() + v.getY());
	}
}
