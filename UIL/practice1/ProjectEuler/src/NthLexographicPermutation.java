import java.util.ArrayList;
import java.util.List;


public class NthLexographicPermutation {
	static int factorials[] = {1,1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	public static void main(String[] args) {
		List a = new ArrayList<Integer>();
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		a.add(9);
		System.out.println(nthPermutation(999999,a));
	}
	public static String nthPermutation(int n, List l){
		//# of elements - 1
		int depth = l.size() - 1;
		if(depth < 0)
			return "";
		
		int perms = factorial(depth);
		
		int t = n / perms;
		
		return l.remove(t) + nthPermutation(n % perms, l);
	}
	public static int factorial(int n){

		if(factorials[n] == -1){
			factorials[n] = factorial(n - 1) * n;
		}
		return factorials[n];
	}
}
