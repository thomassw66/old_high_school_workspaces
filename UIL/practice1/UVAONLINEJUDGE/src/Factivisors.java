
import java.util.Scanner;

public class Factivisors {
	static int [] f(int a){
		int [] f = new int [a+1];
		for(int i = 0; i <= a; i++){
			f[i] = i;
		}
		return f;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while(in.hasNext()){
			int factorial = in.nextInt();
			int b = in.nextInt();
			in.nextLine();
			if(divides(b,factorial))
				System.out.printf("%d divides %d!\n",b,factorial);
			else 
				System.out.printf("%d does not divide %d!\n",b,factorial);
			
		}
	}
	static boolean divides(int a, int fact){
		int [] factorial = f(fact);
		
		int d = 2;
		while(a > 1){
			while(a % d == 0){
				
				a /= d;
				boolean stillAlive = helper(factorial,d);
				if(!stillAlive)return false;
			}
			d++;
		}
		return true;
	}
	static boolean helper(int [] a, int d){
		for(int i = 1; i < a.length; i++){
			if(a[i] % d == 0){
				a[i] = a[i] / d;
				return true;
			}
		}
		return false;
	}
}