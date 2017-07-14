public class LargestPrimeFactor {
	
	public static void main(String[] args) {
		long llll = 600851475143L;
		factor(llll,2);
	}
	public static void factor(long num, long divisor){
		if(num < divisor)return;
		
		while(num % divisor == 0){
			num /= divisor;
			System.out.println(divisor);
		}
		
		factor(num,++divisor);
	}
}
