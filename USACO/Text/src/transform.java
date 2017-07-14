/*
ID: thomass1
LANG: JAVA
TASK: transform
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class transform {

	public static void main(String p[]) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter (new FileWriter("transform.out"));
		
		int n = Integer.parseInt(in.readLine());
		char [][] orig = new char [n][];
		char [][] tran = new char [n][];
		for(int i = 0; i < n; i++){
			orig [i] = in.readLine().toCharArray();
		}

		for(int i = 0; i < n; i++){
			tran [i] = in.readLine().toCharArray();
		}
		out.println(t(orig,tran));
		out.close();
		System.exit(0);
	}
	static int t(char [][] original, char [][] transformed){
		if(equals(rot90(original),transformed))return 1;
		if(equals(rot180(original),transformed))return 2;
		if(equals(rot270(original),transformed))return 3;
		if(equals(ref(original),transformed))return 4;

		char [][] a = ref(original);
		if(equals(rot90(a),transformed))return 5;
		if(equals(rot180(a),transformed))return 5;
		if(equals(rot270(a),transformed))return 5;
		
		if(equals(original,transformed))return 6;
		
		return 7;
	}
	static char [][] ref(char [][] a){
		char [][] b = new char [a.length][a.length];
		for(int i = 0; i < a.length; i++){
			for (int j = 0; j < a.length; j++){
				b[i][a.length - 1 - j] = a[i][j];
			}
		}
		return b;
	}
	static char [][] rot90(char [][] a){
		char [][] b = new char[a.length][a.length];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				b[j][a.length - 1 - i]  = a[i][j];
			}
		}
		return b;
	}		
	static char [][] rot270(char [][] a){
		char [][] b = new char[a.length][a.length];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				b[a.length - 1 - j][i]  = a[i][j];
			}
		}
		return b;
	}
	static char [][] rot180(char [][] a){
		char [][] b = new char[a.length][a.length];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				b[a.length - 1 - i][a.length - 1 - j]  = a[i][j];
			}
		}
		return b;
	}
	static boolean equals(char [][] a, char [][] b){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				if(a[i][j] != b[i][j])return false;
			}
		}
		return true;
	}
}
