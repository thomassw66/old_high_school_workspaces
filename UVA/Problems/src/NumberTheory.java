
public class NumberTheory {

	public static void main(String []args){
		for(long i = 2; i < Integer.MAX_VALUE; i ++){
			
		}
	}
	public static long gcd(long a, long b){
		if(a % b == 0)
			return b;
		else return gcd(b,a%b);
	}
}
