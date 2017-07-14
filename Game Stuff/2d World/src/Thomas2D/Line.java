package Thomas2D;

public class Line {
	//ax + by + c = 0
	double a,b,c;
	
	public Line(Point a, Point b){
		if(Math.abs((a.getX() - b.getX())) <= Geometry.ELIPSON)
		{
			this.a = 1;
			this.b = 0;
			this.c = -a.getX();
		} 
		else 
		{
			this.a = - (a.getY() - b.getY())/(a.getX() - b.getX());
			this.b = 1;
			this.c = - (this.a * a.getX() - this.b * a.getY());
		}
	}
	public Line(Point p, double slope){
		this.a = - slope;
		this.b = 1;
		this.c = - (this.a * p.getX()) - (this.b * p.getY());
	}

	public static boolean parrallel(Line a, Line b){
		return (Math.abs(a.a - b.a) <= Geometry.ELIPSON) && 
				(Math.abs(a.b - b.b) <= Geometry.ELIPSON);
	}
	public Point closestPoint(Point p){
		if(this.b == 0){
			return new Point(-this.c, p.getY());
		}else{
			
		}
		return p;
	}
	double compareTo(Point p){
		return (a * p.getX()) + (b * p.getY())  + c;
	}
}
