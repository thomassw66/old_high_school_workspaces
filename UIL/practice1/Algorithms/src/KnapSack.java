import java.util.Scanner;


public class KnapSack {
	static Scanner in;
	static int [] costWithSpace;
	public static void main(String [] args){
		 in = new Scanner (System.in);
		System.out.println("How many items are there:");
		int N = in.nextInt();
		System.out.println("How much space is there:");
		int space = in.nextInt();
		System.out.println("What are the values of the Items");
		int [] vals = readArray(N);
		System.out.println("What are the weights of each of the Items");
		int [] costs = readArray(N);
		costWithSpace = new int[space+1];
		for(int i = 0; i < space+1; i++)costWithSpace[i] = -1;
		costWithSpace[0] = 0;
		System.out.println(maxVal(space,vals,costs));
	}
	public static int maxVal(int space, int vals[], int cost[]){
		System.out.println(space);
		if(costWithSpace[space] == -1){
			int mv = 0;;
			for(int i = 0; i < vals.length; i++){
				int ns = space - cost[i];
				if(ns >= 0){
					int nv = vals[i] + maxVal(ns,vals,cost);
					if(nv >= mv){
						mv = nv;
					}
				}
			}
			costWithSpace[space] = mv;
		}
		System.out.println(space+ ": " + costWithSpace[space]);
		return costWithSpace[space];
	}
	public static int[] readArray(int N){
		int [] a = new int[N];
		for(int i = 0; i < N; i++){
			a[i] = in.nextInt();
		}
		return a;
	}
}
