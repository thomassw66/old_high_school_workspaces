import java.util.Scanner;


public class Counter {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		String s= "";
		int n = 0;
		while (in.hasNext()){
			
			n++;
			System.out.println(n + " " + in.next());
		}

		System.out.println(n);
	}
}
