import java.util.Arrays;
import java.util.Scanner;


public class PrmeRings {

	static int [] primes = {2,3,5,7,11,13,17,19,23,29,31};
	static boolean used [];
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int c = 1;
		while(in.hasNext())
		{
			//long s = System.currentTimeMillis();
			if(c > 1)System.out.println();
			int n = in.nextInt();
			used = new boolean [n+1];
			int [] current = new int [n];
			current[0] = 1;
			used[1] = true;
			
			System.out.println("Case "+ (c++) +":");
			printRings(current,1,n);
			//System.out.println(System.currentTimeMillis() - s);
			
		}
	}
	static void printRings(int [] current, int index ,int n){
		
		if(index == n){
			if(isprime(current[n-1] + 1)){
				for(int i = 0; i < n-1; i++)
					System.out.print(current[i]+" ");
				System.out.println(current[n-1]);
			}
			return;
		}
		int last = current[index-1];
		for(int i = 0; i < primes.length; i++){
			int m = primes[i] - last;
			if(m > 0 && m <= n && !used[m]){
				current[index] = m;
				used[m]=true;
				printRings(current,index+1,n);
				used[m] = false;
			}
		}
	}
	public static boolean isprime(int n){
		for(int i = 0; i < primes.length; i++)
			if(n == primes[i])return true;
		return false;
	}
}

/*
2
4
6
8
10
12
14
16
*/