import java.util.Scanner;


public class Haywire {

	public static void main(String p[]){
		Scanner in = new Scanner (System.in);
		System.out.println(diff(6,1)+ " "+ diff(1,6));
		int COWS = in.nextInt();

		int sum = 0;
		for(int i = 1; i <= COWS; i++){
			sum += diff(i,in.nextInt());
			sum += diff(i,in.nextInt());
			sum += diff(i,in.nextInt());
		}
		System.out.println(sum);
	}
	static int diff(int a, int b){
		return Math.min(Math.abs(a-b), Math.abs(b-a));
	}
}
