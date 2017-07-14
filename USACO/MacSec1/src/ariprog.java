/*
ID: thomass1
LANG: JAVA
TASK: ariprog
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class ariprog {

	public static void main(String p[]) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new FileWriter("ariprog.out"));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		boolean [] bisquares = new boolean [1000000];
		for(int i = 0; i <= M; i++){
			for(int j = 0; j <= i; j++){
				bisquares[i*i+j*j]= true;
			}
		}
		//System.out.println(bisquares);
		int l = M*M*2;// largest bisquare in the set
		boolean s = false;
		for(int diff = 1; diff < l; diff++){
			for(int i = 0; i <= l-diff*(N-1); i++){
				// see if there is a subsequence with starting a = i b = diff and length n
				int a = i;
				int b = diff;
				boolean yes = true;
				for(int x = 0; x < N; x++){
					if(!bisquares[a + x*b]){
						yes = false;
						break;
					}
				}
				if(yes){
					s = true;
					out.println(a + " " + b);
				}
			}
		}
		if(!s){
			out.println("NONE");
		}
		in.close();
		out.close();
		System.exit(0);
	}
}
