/*
ID:thomass1
LANG: JAVA
TASK: dualpal
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class dualpal {

	public static void main(String [] apre) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new FileWriter("dualpal.out"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		while(N > 0){
			S++;
			if(palRate(S) >= 2){
				N--;
				out.println(S);
			}
		}
		out.close();
		System.exit(0);
	}
	static int palRate(int s){
		int p = 0;
		for(int B = 2; B <= 10; B++){
			if(isPal(Integer.toString(s, B)))p++;
		}
		return p;
	}
	static boolean isPal(String s){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
}
