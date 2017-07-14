
public class SquareRoot {

	public static void main(String [] argrs){
		double s = sqrt(1E8);
		System.out.println(s);
		System.out.println(s*s);
	}
	public static double sqrt(double x){
		double m = x / 2;
		double delta = m;
		
		while(Math.abs(m*m - x) > .00000000001){
			//System.out.println(Math.abs(m*m - x));
			if(m*m < x){
				m += delta;
			} else {
				m -= delta;
			}
			delta /= 2;
		}
		
		return m;
	}
}
