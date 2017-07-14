
public class LinearRegression {
	static Operator mul = new Operator(){
		public double f(double a, double b){
			return a * b;
		}
	};
	public static void main(String[] args) {
		double x[] = {2,1,0,-1,-2};
		double y[] = {2,4,6,8,10};
	}
	public static double slopeLBF(double [] x, double [] y){
		int N = x.length;
		return (N*sum(result(x,y,mul)) - sum(x)*sum(y))/(N*sum(result(x,x,mul)) - Math.pow(sum(x), 2));
	}
	public static double interceptLBF(double [] x, double [] y, double slope){
		int N = x.length;
		return (sum(y) - sum(x) * slope)/N;
	}
	static double sum(double [] a){
		double s = 0;
		for(int i = 0; i < a.length; i++){
			s += a[i];
		}
		return s;
	}
	static double [] result (double [] a, double [] b, Operator f){
		double [] s = new double [a.length];
		for(int i = 0; i < a.length; i++){
			s[i] =  f.f(a[i], b[i]);
		}
		return s;
	}
}
interface Operator {
	public double f(double a, double b);
}