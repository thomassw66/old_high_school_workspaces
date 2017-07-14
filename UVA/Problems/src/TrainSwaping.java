import java.util.Scanner;


public class TrainSwaping {
	static int swaps;
	public static void main(String [] argas){
		Scanner in = new Scanner (System.in);
		int N = in.nextInt();
		for(int i = 0; i < N; i++){
			swaps = 0;
			int m = in.nextInt();
			int [] toSort = new int[m];
			for(int j = 0; j < m; j++){
				toSort[j] = in.nextInt();
			}
			insertionSort(toSort);
			System.out.printf("Optimal train swapping takes %d swaps.\n",swaps);
		}
	}
	public static void insertionSort(int [] a){
		int N = a.length;
		for(int i = 1; i < N; i++){
			int j = i;
			while(j > 0 && a[j] < a[j - 1]){
				swap(a,j,j-1);
				j--;
			}
		}
	}
	public static void swap(int []a, int x, int y){
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
		swaps++;
	}
}
