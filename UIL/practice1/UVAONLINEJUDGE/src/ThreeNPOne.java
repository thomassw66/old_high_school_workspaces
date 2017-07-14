import java.util.Scanner;


public class ThreeNPOne {

	public static void main(String[] args) {
		//System.out.println(cycle (22));
		Scanner in = new Scanner (System.in);
		while(in.hasNext()){
			int l = in.nextInt(); 
			int h = in.nextInt();
			int m = 0;
			for(int i = l; i <= h; i++){
				m = Math.max(m, cycle(i));
			}
			System.out.printf("%d %d %d\n",	l,h,m);
		}
	}
	static int cycle(int n){
		int len = 1;
		while(n > 1){
			//if odd
			if(n % 2 == 1){
				n = 3 * n + 1;
			}else {
				n = n / 2;
			}
			len++;
		}
		return len;
	}
}
