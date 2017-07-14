import java.util.Scanner;


public class Change {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int f = in.nextInt();
		for(int i = 0; i < f ; i++){
			int n = in.nextInt();
			System.out.printf("%d\n",ways(n,0));
		}
	}
	static final int [] denominations = {50, 25, 10, 5, 1};
	static final int LAST = 4;
	public static int ways(int n, int d){
		if(d == LAST)return 1;
		int count = 0;
		while(n > 0){
			count += ways(n,d+1);
			n -= denominations[d];
		}
		return count;
	}
}
