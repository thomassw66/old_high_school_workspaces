package Thomas2D;

public class Tuple {
	private double x,y;
	
	public Tuple(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	protected void setX(double x){
		this.x = x;
	}
	protected void setY(double y){
		this.y = y;
	}
}
