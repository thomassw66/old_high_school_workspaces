
public class SumOfMultiplesOfThreeAndFive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int total = smartSum(5,999) + smartSum(3,999) - smartSum(15,999); 
		System.out.println(total);
	}
	//this takes the smarter approach though O(N)
	public static int smartSum(int a, int limit){
		limit = limit - limit % a;
		int nums = limit / a;
		int sum = ((a + limit) * nums) / 2;
		return sum;
	}
	//sums all multiples of a less than limit the way you'd think
	public static int sumOfMultiples(int a, int limit){
		int sum = 0;
		for(int i = a; i <= limit; i += a)
			sum += i;
		return sum;
	}
}
