import java.awt.Point;



public class WallyWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.printf("%.03f",time(5,2,7,576,
								6,1,6,100)/2);
		
	}
	public static double time(int x1,int y1, int x2, int y2, int wallx1,int wally1,int wallx2, int wally2){
		//convert the points to line segments
		Line directToLovers = new Line(new Line.Point2d (x1,y1),new Line.Point2d(x2,y2));
		Line wall = new Line(new Line.Point2d (wallx1,wally1),new Line.Point2d(wallx2,wally2));
		
		//figure if wall is in between 'lovers'
		if(directToLovers.onSegment(Line.interSect(directToLovers, wall))){
			//if it is the add the two distances to the nearest verticy of wall 
			return Math.min(
					Math.sqrt(((x1 - wallx1)*(x1 - wallx1)+(y1 - wally1)*(y1 - wally1))) + Math.sqrt((x2 - wallx1)*(x2 - wallx1)+(y2 - wally1)*(y2 - wally1)),
					Math.sqrt(((x1 - wallx2)*(x1 - wallx2)+(y1 - wally2)*(y1 - wally2))) + Math.sqrt((x2 - wallx2)*(x2 - wallx2)+(y2 - wally2)*(y2 - wally2)));
		}else {	
			//if not its the distance from wally to girl
			return Math.sqrt(((directToLovers.a.x - directToLovers.b.x) * (directToLovers.a.x - directToLovers.b.x)) + ((directToLovers.a.y - directToLovers.b.y) * (directToLovers.a.y - directToLovers.b.y)));
		}
	}
	static class Line{
		private Point2d a,b;
		private double slope,Intersept;
		private boolean infiniteSlope;

		public Line (Point2d o, Point2d t){
			a = o;
			b = t;
			if(a.x == b.x){
				infiniteSlope = true;
			}else{
				slope 		= (b.y - a.y) / (b.x - a.x);
				Intersept 	= a.y - (a.x * slope);
			}
		}
		public boolean onSegment(Point2d a){
			double maxX = Math.max(this.a.x, this.b.x);
			double minX = Math.min(this.a.x, this.b.x);
			double maxY = Math.max(this.a.y, this.b.y);
			double minY = Math.min(this.a.y, this.b.y);
			
			return(a.x <= maxX && a.x >= minX && a.y <= maxY && a.y >= minY);
		}
		static Point2d interSect(Line a, Line b){
			if(Line.parallel(a, b))
				return null;
			if(a.infiniteSlope() || b.infiniteSlope()){
				if(a.infiniteSlope()){
					Line temp = a;
					a = b;
					b = temp;
				}
				return new Point2d(b.b.x,a.yAtX(b.b.x));
				
				
			}else{
				
				// m2 * x + b2 = mx + b
				double nm = a.slope() - b.slope();
				double nyint = b.yIntersept() - a.yIntersept();
				
				double interseptx = nyint / nm;
				
				return new Point2d(interseptx,a.yAtX(interseptx));
			}
		}
		double yAtX(double x){
			if(this.infiniteSlope){
				if(x == a.x)
					return Integer.MAX_VALUE;
				return Integer.MIN_VALUE;
			}
			return slope() * x + yIntersept();
		}
		double slope(){
			return slope;
		}
		double yIntersept(){
			return Intersept;
		}
		boolean infiniteSlope(){
			return infiniteSlope;
		}
		static boolean parallel (Line a, Line b){
			if(a.infiniteSlope() || b.infiniteSlope()){
					return a.infiniteSlope() && b.infiniteSlope();
			}else {
				return (a.slope() == b.slope());
			}
		}
		static class Point2d{
			public Point2d(double x, double y){
				this.x = x;
				this.y = y;
			}
			double x,y;
		}
	}

}
