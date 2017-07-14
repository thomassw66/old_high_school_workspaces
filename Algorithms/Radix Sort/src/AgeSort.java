import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class AgeSort {
	static int RADIX = 3;
	//sorts a list of customers ages varying 0 - 130
	public static void main(String []args){
		int [] ages = new int[10000000];
		
		for(int i = 0; i < ages.length; i++){
			ages[i] = (int) (Math.random() * 120);
		}
		System.out.print("Starting...");
		long n = System.nanoTime();
		radix_sort_2s(ages);
		long n1 = System.nanoTime();
		System.out.println("...Done");
		System.out.println("Sorted in..."+(((double)(n1 - n))/ (double)1000000000)+" seconds");
		
		for(int i = 0; i < ages.length; i += 1000000){
			System.out.print(ages[i]+" ");
		}
		//System.out.println(Arrays.toString(ages));
		
	}
	public static int [] radix_sort_10s(int [] ages){
		
		int [] temp = ages.clone();
		
		ArrayList<Integer> [] radix = new ArrayList[10];
		
		for(int i = 1; i <= RADIX ; i++){
			int place = (int)Math.pow(10, i-1);
			
			for(int j = 0; j < radix.length; j++){
				radix[j] = new ArrayList<Integer>();
			}
			
			for(int j = 0; j < ages.length; j++){
				radix[(temp[j] / place) % 10].add(temp[j]);
			}

			
			int index = 0;
			for(ArrayList a : radix){
				for(Object num : a){
					temp[index++] = (Integer)num;
				}
			}
		}
		return temp;
	}
	//very fast
	public static void radix_sort_2s(int [] toSort){
		
		int  [][] pleases = new int[2][toSort.length];

		int [] count = {0,0};
		
		for(int i = 0; i < 8; i ++){
				
			for(int j = 0; j < toSort.length; j++){
				int which = (toSort[j] >> i) & 1;
				pleases[which][count[which]++] = toSort[j];
			}
			
			int index = toSort.length - 1;
			while(count[1] > 0)
				toSort [index--] = pleases[1][--count[1]];
			while(count[0] > 0)
				toSort [index--] = pleases[0][--count[0]];
		}
	}
}
