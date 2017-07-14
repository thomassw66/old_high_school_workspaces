import java.util.Scanner;


public class CHRECT {

	public static void main(String []arfs){
		Scanner in = new Scanner(System.in);
		
		int c= in.nextInt();
		for(int i = 0; i < c; i++){
			int n = in.nextInt();
			int m = in.nextInt();
			int p = in.nextInt();
			
			if(n == 1 || m == 1){
				if(n == 1 && m == 1){
					System.out.println(0);
				}
				else {
					System.out.println(p);
				}
			}
			else {
				int x = p / 2 + p % 2;
				System.out.println(x);
			}
		}
	}
}
