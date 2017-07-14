import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while(in.hasNext()){
			int money = in.nextInt(); // amount of money 
			int cost = in.nextInt(); //cost of Banger
			System.out.println(money/cost); //# of bangers we can buy
		}
	}

}
