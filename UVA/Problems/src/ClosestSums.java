import java.util.Scanner;

//ACCEPTED
public class ClosestSums {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		int n;
		int CASE = 1;
		while((n = in.nextInt()) != 0){
			System.out.printf("Case %d:\n",CASE++);
			int nums[] = new int [n];
			int sums[]= new int [(n - 1)*(n + 1 - 1) / 2];
			int count = 0;
			
			for(int i = 0; i < n; i++){
				nums [i] = in.nextInt();
				for(int j = 0; j < i; j ++){
					sums[count++] = nums [i] + nums[j];
				}
			}
			//System.out.println(Arrays.toString(sums));
			int m = in.nextInt(); // number of queries
			for(int i = 0; i < m; i++){
				int q = in.nextInt();
				System.out.printf("Closest sum to %d is %d.\n",q,closestSum(q,sums));
			}
		}
	}
	static int closestSum(int query, int sums[]){
		int minDif = Integer.MAX_VALUE;
		int closest = Integer.MAX_VALUE;
		
		for(int i : sums){
			int d = Math.abs(query - i);
			if(d < minDif){
				minDif = d;
				closest = i;
			}
		}
		return closest;
	}
	
}
/*
5 
3
12
17
33
34
3
1
51
30
3
1
2
3
3
1
2
3
3 
1
2
3
3
4
5
6
0
*/