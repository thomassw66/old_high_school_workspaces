/*
ID: thomass1
LANG: JAVA
TASK: barn1
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class barn1 {

	public static void main(String p[]) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new FileWriter("barn1.out"));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(M > C){
			out.println(C);
			out.close();
			System.exit(0);
		}
		
		int [] occupied = new int [C];
		int [] cells_between = new int [C-1];
		
		for(int i = 0; i < C; i++)
			occupied[i] = Integer.parseInt(in.readLine());
		
		Arrays.sort(occupied);
		
		for(int i = 0; i < C-1; i++)
			cells_between[i] = occupied[i+1] - occupied[i]-1;
		
		Arrays.sort(cells_between);
		
		int total_covered = S;
		for(int i = 0; i < M-1; i++)
			total_covered -= cells_between[C - 2 - i];
		total_covered -= (occupied[0] - 1 + S - occupied[occupied.length - 1]);
		
		out.println(total_covered);
		
		out.close();
		System.exit(0);
	}
}
