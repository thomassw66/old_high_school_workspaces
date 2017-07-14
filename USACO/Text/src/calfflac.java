/*
ID: thomass1
LANG: JAVA
TASK: calfflac
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class calfflac {

	public static void main(String [] ats) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("calfflac.in"));
		PrintWriter out = new PrintWriter(new FileWriter("calfflac.out"));
		char [] a = new char[20000];
		int n = in.read(a);
		char [] b = new char [n];
		System.arraycopy(a, 0, b, 0, n);
		String s = new String(b);
		String pal = longestPal(s);
		
		out.println(alphs(pal));
		out.println(pal);
		out.close();
		in.close();
		System.exit(0);
	}
	static int alphs(String s){
		int c = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a' || s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')
				c++;
		}
		return c;
	}
	static String longestPal(String s){
		int max = 0;
		String p = "";
		for(int i = 1; i < s.length(); i++){
			
			if(i < s.length()-1){
				//check 4 odd
				String odd = lengthofpal(s,i-1,i+1);
				if(odd.length() > max){
					p = odd;
					max = odd.length();
				}
			}
			//check 4 even
			String even = lengthofpal(s,i-1,i);
			if(even.length() > max){
				p = even;
				max = even.length();
			}
		}
		
		return p;
	}
	public static String lengthofpal(String s, int b, int e){
		int length = e - b - 1;
		int temp_e = e;
		int temp_b = b;
		outer:
			while (true){
				if(b < 0 || e >= s.length()) break outer;
				
				while(!Character.isLetter(s.charAt(b))){b--;if(b < 0)break outer;}
				while(!Character.isLetter(s.charAt(e))){e++;if(e >= s.length())break outer;}
				
				if(Character.toLowerCase(s.charAt(b)) == Character.toLowerCase(s.charAt(e))){
					temp_e = e;
					temp_b = b;
				}
				else 
					break outer;
				b--;
				e++;
			}
		return s.substring(temp_b, temp_e+1);
	}
}
// sdbds
