/*
ID: thomass1
LANG: JAVA
TASK: crypt1
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class crypt1 {

	public static void main(String []args) throws IOException{
		Scanner in = new Scanner(new File("crypt1.in"));
		PrintWriter out = new PrintWriter(new FileWriter("crypt1.out"));
		int n = in.nextInt();
		boolean canuse [] = new boolean[10];
		
		for(int i = 0; i < n; i++){
			int x = in.nextInt();
			canuse[x] = true;
		}
		out.println(dfs(canuse,0));
		in.close();
		out.close();
		System.exit(0);
	}
	static int [] x = new int[5];
	
	static int dfs(boolean [] canuse, int depth){
		if(depth >= x.length ){
			if(works(canuse))return 1;
			else return 0;
		}
		//System.out.println(depth);
		int s = 0;
		for(int i = 0; i < canuse.length; i++){
			if(canuse[i]){
				x[depth] = i;
				s += dfs(canuse, depth+1);
				x[depth]=0;
			}
		}
		return s;
	}
	static boolean works(boolean [] canuse){
		int a = x[0]+x[1]*10+x[2]*100;
		
		int b = a * x[3];
		int c = a * x[4];
		int f = b + c *10;
		if(b > 999 || c > 999 || f > 9999) return false;
		return canuse[b%10] && canuse[(b/10)%10] && canuse[b/100] &&
				canuse[c%10] && canuse[(c/10)%10] && canuse[c/100] &&
				canuse[f%10] && canuse[f / 10 % 10] && canuse[f / 100 % 10] && canuse[f /1000];
	}
}
