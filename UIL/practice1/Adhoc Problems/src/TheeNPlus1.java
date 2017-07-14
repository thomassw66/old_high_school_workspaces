import java.util.Scanner;


public class TheeNPlus1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			int max = 0;
			int l = in.nextInt();
			int h = in.nextInt();
			
			int low = Math.min(l, h);
			int high = Math.max(l, h);
			
			for(int i = low; i <= high; i++){
				int length = cycleLength(i);
				if(length > max)
					max = length;
			}
			System.out.printf("%d %d %d\n", l, h, max);
			in.nextLine();
		}
	}
	public static int cycleLength(int n){
		int count = 1;
		while(n > 1){
			
			if((n % 2) == 0){
				//even
				n = n / 2;
			}else {
				//odd
				n = 3 * n + 1;
			}
			count++;
		}
		return count;
	}
}
