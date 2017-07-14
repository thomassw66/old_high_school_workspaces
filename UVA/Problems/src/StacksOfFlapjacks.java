import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class StacksOfFlapjacks {


	public static void main(String []athd){
		Scanner in = new Scanner (System.in);
		while(in.hasNext()){
			String n = in.nextLine();
			String s[] = n.split(" ");
			int [] nums = new int [s.length];
			for(int i = 0; i < s.length; i++){
				nums [s.length - i - 1] = Integer.parseInt(s[i]);
			}
			System.out.println(n);
			flippingAlg(nums);
		}
	}
	static void flippingAlg(int a[]){
		int N = a.length;
		for(int i = 0; i < N; i++){
			int index = indexOfMax(a,i);
			if(index == i) continue;
			else {
				if(index != N - 1){ // move it to the end if not already
					flip(a,index);
				}
				flip(a,i);
			}
		}
		System.out.println(0);
	}
	static int indexOfMax(int a[],int start){
		int max = Integer.MIN_VALUE;
		int ind = -1;
		for(int i = start; i < a.length; i++){
			if(a[i] > max){
				max = a[i];
				ind = i;
			}
		}
		return ind;
	}
	// reverses elements from index to end
	static void flip(int [] a, int index){
		int i = index;
		int j = a.length - 1;
		while(i < j){
			swap(a, i, j);
			i++;
			j--;
		}
		System.out.print(index + 1 + " ");
	}
	static void swap(int [] a, int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
