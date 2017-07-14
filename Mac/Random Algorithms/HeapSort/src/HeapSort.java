import java.util.Arrays;


public class HeapSort {

	public static void main(String []agra){
		int [] a= {4,31,5,1,6,67,2,3};
		heapsort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void heapsort(int [] a){
		for(int j = 0; j < a.length; j++){
			for(int i = 1; i < a.length-j; i++){
				int index = i;
				while(index > 0){
					int parent = (index - 1) / 2;
					
					if(a[parent] >= a[index]){
						break;
					}
					//swap parent and child
					int t = a[parent];
					a[parent] = a[index];
					a[index] = t;
					//move down
					index = parent;
				}
			}
			int i = a[0];
			a[0] = a[a.length-j-1];
			a[a.length - j - 1] = i;
		}
	}
}
