import java.util.Scanner;


public class WordScramble{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()){
			String [] s = in.nextLine().split(" ");
			System.out.print(flip(s[0]));
			for(int j = 1; j < s.length; j++){
				System.out.print(" "+flip(s[j]));
			}
			System.out.println();
		}
	}
	public static String flip(String s )
	{
		
		String ret = "";
		for(int i = 0; i< s.length(); i++){
			ret = s.charAt(i) + ret;
		}
		return ret;
	}
}
