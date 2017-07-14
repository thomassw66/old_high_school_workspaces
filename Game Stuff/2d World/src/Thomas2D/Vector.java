package Thomas2D;

public class Vector extends Tuple {

	public Vector(double x,double y){
		super(x,y);
	}
	//Vector addition
	public Vector plus(Vector v){
		return new Vector(this.getX()+v.getX(),this.getY() + v.getY());
	}
	//vector subtraction
	public Vector minus(Vector v){
		return this.plus(v.inverse());
	}
	//+=
	public void plusEqual(Vector v){
		this.setX(this.getX()+v.getX());
		this.setY(this.getY() + v.getY());
	}
	//-=
	public void minusEqual(Vector v){
		plusEqual(v.inverse());
	}
	//flips the vector
	public Vector inverse(){
		return new Vector(-this.getX(),-this.getY());
	}
	public double magnitudeSquared(){
		return this.getX()* this.getX() + this.getY()* this.getY();
	}
	//the hypotenuse of our vector
	public double magnitude(){
		return Math.sqrt(this.magnitudeSquared());
	}
}
