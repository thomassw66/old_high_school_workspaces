import java.util.Scanner;



public class Steps {

	/*
	1 1 //1
	2 2 //1 1
	3 4 //1 2 1
	4 6 //1 2 2 1
	5 9 //1 2 3 2 1
	
	2147483648
	 */
	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		long c = in.nextLong();
		for(long count = 0; count < c; count ++){
			long s = in.nextLong();
			long e = in.nextLong();
			long distance = e - s;
			long steps;
			long traveled = 0;
			long change = 1;
			for(steps = 0; traveled < distance ; steps ++){
				traveled += change;
				if(steps % 2 == 1)
					change ++;
			}
			System.out.println(steps);
		}
	}
}
