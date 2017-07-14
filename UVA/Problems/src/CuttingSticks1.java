import java.util.Scanner;


public class CuttingSticks1 {

	public static void main(String []args){
		Scanner in = new Scanner (System.in);
		int L;
		while((L= in.nextInt()) != 0){
			int n = in.nextInt();
			int N = n + 2;
			int [] cuts = new int [N];
			
			cuts[0] = 0;
			for(int i = 1; i < N - 1; i++)
				cuts[i] = in.nextInt();
			cuts[N-1] = L;
			System.out.printf("The minimum cutting is %d.\n",cut(cuts,0,N-1));
		}
	}
	static int cut (int [] cuts, int start, int fin){
		if(fin - start < 2)
			return 0;
		int thiscut = cuts[fin] - cuts[start];
		int min = Integer.MAX_VALUE;
		for(int i = start+1; i <= fin-1; i++){
			int left = cut(cuts,start,i);
			int right = cut(cuts,i,fin);
			if(right + left < min)
				min = right+left;
		}
		return thiscut+min;
	}
}
