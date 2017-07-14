/*
ID: thomass1
LANG: JAVA
TASK: milk2
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class milk2 {

	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
		int n = Integer.parseInt(in.readLine());
		int [] start = new int [n];
		int [] end = new int [n];
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			end [i] = Integer.parseInt(st.nextToken());
		}
		int startTime = min(start);
		int endTime = max(end);

		int tcow = 0;
		int tnocow = 0;
		int mcow = 0, mnocow = 0;
		for(int i = startTime; i < endTime; i++){
			boolean cow = false;
			for(int j = 0; j < n; j++){
				if( i < end[j] && i >= start[j]){
					cow = true; 
					break;
				}
			}
			if(cow){
				tcow++;
				tnocow=0;
			}else{
				tnocow++;
				tcow = 0;
			}
			mcow = Math.max(mcow, tcow);
			mnocow = Math.max(tnocow, mnocow);
		}
		//System.out.println(startTime + " " + endTime);
		PrintWriter out = new PrintWriter(new FileWriter("milk2.out"));
		out.println(mcow + " " + mnocow);
		out.close();
		System.exit(0);
	}
	static int max(int [] a){
		int max = a[0];
		for(int i = 1; i < a.length; i++){
			max = Math.max(a[i] , max);
		}
		return max;
	}
	static int min(int [] a){
		int min = a[0];
		for(int i = 1; i < a.length; i++){
			min = Math.min(a[i] , min);
		}
		return min;
	}
}
