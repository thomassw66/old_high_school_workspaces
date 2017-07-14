package Thomas2D;

public class Test {

	public static void main(String []ar ){
		long l = System.currentTimeMillis();
		double f = Point.distance(new Point (5,5), new Point(0,0));
		System.out.println(f);
		System.out.println(System.currentTimeMillis() - l);
	}
}
