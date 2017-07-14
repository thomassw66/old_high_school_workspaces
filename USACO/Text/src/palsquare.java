/*
ID: thomass1
LANG: JAVA
TASK: palsquare
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class palsquare {

	public static void main(String [] args) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new FileWriter("palsquare.out"));;
		
		int B = Integer.parseInt(in.readLine());
		for(int i = 1; i <= 300; i++){
			int s = i * i;
			
			String N = Integer.toString(i, B).toUpperCase();
			String NS = Integer.toString(s, B).toUpperCase();
			if(isPal(NS))
				out.println(N + " " + NS);
		}
		out.close();
		System.exit(0);
	}
	static boolean isPal(String s){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
}
