/*
ID: thomass1
LANG: JAVA
TASK: milk
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class milk {

	public static void main(String [] asrgsf) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new FileWriter("milk.out"));
		
		StringTokenizer st;
		st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Farmer [] f = new Farmer[M];
		
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(in.readLine());
			f[i] = new Farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(f);
		
		int totalMilk = 0;
		int totalCost = 0;
		int index = 0;
		while(totalMilk < N){
			if(f[index].amount > 0){
				totalMilk ++;
				f[index].amount--;
				totalCost += f[index].cost;
			}else{
				index++;
			}
		}
		out.println(totalCost);
		out.close();
		System.exit(0);
	}
}
class Farmer implements Comparable<Farmer>{
	int cost;
	int amount;
	public Farmer(int c, int a){
		cost = c;
		amount = a;
	}
	public int compareTo(Farmer a) {
		return this.cost - a.cost;
	}
	
}