import java.util.Scanner;


public class SolutionChecker{
	static String EOS = "!!!!!";
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.println("please input two outputs");
		String sol1 = "",sol2 = "";
		String l = in.nextLine();
		while(!l.equals(EOS)){
			sol1+=l;
		}
		System.out.println("got it");
		l = in.nextLine();
		while(!l.equals(EOS)){
			sol2+=l;
		}
		System.out.println(sol1.equals(sol2));
	}

}
