import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Permutations {
	static long ONE = 1;
	static long UNALLOCATED = -1;
	//so were only calculating factorials once
	static long [] fact = {ONE,ONE,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,
				UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,
				UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED,UNALLOCATED};
			
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int cases = Integer.parseInt(in.nextLine());
		for(int i = 0; i < cases; i ++){
			String s = in.nextLine();
			List<Character> l = new LinkedList<Character>();
			for(char c : s.toCharArray()){
				l.add(c);
			}
			Collections.sort(l);
			long b = Long.parseLong(in.nextLine());
			System.out.println(nthPermutation(b,l));
		}
	}
	static String nthPermutation(long n, List<Character> l){
		if(l.size() <= 0)
			return "";
		
		int depth = l.size() - 1;
		long f = factorial (depth);
		
		return l.remove((int)(n / f)) + nthPermutation(n % f,l);
	}
	static long factorial(int n){
		if(fact[n] == UNALLOCATED)
		{
			//allocate
			fact[n] = n * factorial(n-1);
		}
		return fact[n];
	}
}
