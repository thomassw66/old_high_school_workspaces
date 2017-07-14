import java.util.Scanner;


public class D {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int condemned;
		while((condemned = in.nextInt())!=0){
			System.out.println((int)(Math.sqrt(condemned)));
		}
	}
}
