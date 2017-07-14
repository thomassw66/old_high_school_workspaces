
public class M {
	public static void main(String[] args) {
		System.out.println(pow(2,6.0) );
		System.out.println(Math.pow(2,6));
	}
	public static double pow(double  a, double b){
		if(b % 2.0 == 0){
			double l = pow(a, b/2);
			return l*l;
			
		}
		return  Math.expm1(Math.log(a) * b)+1;
	}
}
