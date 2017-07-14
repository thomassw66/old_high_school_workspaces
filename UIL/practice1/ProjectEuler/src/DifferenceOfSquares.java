
public class DifferenceOfSquares {
	
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 100; i++){
			for(int j = i + 1; j <= 100; j++){
				sum += i * j;
			}
		}
		System.out.println(2 * sum)
;	}

}
