import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class LovelyHint {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		
		int N = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < N; i++){
			String s = in.nextLine();
			char [] a = alphabets(s).toCharArray();
			Arrays.sort(a);
			ArrayList<Character> alphs = removedup(a);
			longest = new int [alphs.size()];
			lovelyStrings = new ArrayList<String>();
			maxc = 0;
			maxr = 0;
			for(int ab = 0; ab < alphs.size();ab++){
				possible("",ab,alphs);
			}
			/*Collections.sort(lovelyStrings, new Comparator<String>(){
				public int compare(String a, String b){
					return a.length() - b.length();
				}
			});
			int l = lovelyStrings.get(lovelyStrings.size()-1).length();
			int c=0;
			int index = lovelyStrings.size()-1;
			while(lovelyStrings.get(index).length() == l)
				c++;*/
			System.out.println(maxr+1+ " " + maxc);
		}
	}
	static int maxr;
	static int maxc;
	static int r = 0;
	static String tab(int t){
		return '\t' + ((t > 0)?tab(t-1):"");
	}
	static int [] longest;
	static ArrayList<String> lovelyStrings;
	static void possible(String current, int i,ArrayList<Character> a){
		if(r > maxr){
			maxc = 1;
			maxr = r;
		}else if(maxr == r){
			maxc++;
		}
		//int b = 0;
		//int bc = 0;
		String s = current + a.get(i);
		lovelyStrings.add(s);
		//System.out.println(tab(r) + s);
		for(int j = i + 1; j < a.size(); j++){
			if(a.get(j) >= next(a.get(i))){
				r++;
				possible(s,j,a);
				r--;
			}
		}
	}
	static ArrayList<Character> removedup(char c[]){
		int l = c.length;
		ArrayList<Character> in = new ArrayList<Character>(c.length);
		in.add(c[0]);
		for(int i = 1; i < c.length; i++){
			if(c[i] == c[i-1])
				l--;
			else 
				in.add(c[i]);
		}
		return in;
		
	}
	static char next(char c){
		int n = c - 'A' + 1;
		n = n * 5;
		n = (n % 4 == 0)? n / 4: n / 4 + 1;
		return (char)('A' + n - 1);
	}
	static String alphabets(String d){
		String s = "";
		for(int i = 0; i < d.length(); i++){
			if(d.charAt(i) <= 'Z' && d.charAt(i) >= 'A')
				s += d.charAt(i);
		}
		return s;
	}
}
