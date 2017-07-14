import java.util.Scanner;


public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int a;
		while ((a = in.nextInt()) != 0){
			int N = a;
			int G = 0;
			for(int i = 1; i <= N; i++){
				for(int j = i +1; j <= N; j++){
					G += gcd(i,j);
				}
			}
			System.out.println(G);
		}
	}
	public static int gcd(int i, int j){
		if(i % j == 0)return j;
		return gcd(j, i % j);
	}
}
