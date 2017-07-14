import java.util.ArrayList;


public class Prime {

	public static void main(String []args){
		System.out.println(getPrimes(10000000));
	}
	static ArrayList<Long> getPrimes(long N){
		ArrayList<Long> primes = new ArrayList<Long>((int)(N / Math.log(N)));
		for(long i = 2; i < N; i++){
			boolean p = true;
			for(int j = 0; j < primes.size() ; j++){
				if( primes.get(j)* primes.get(j) > i)
					break;
				if( i % primes.get(j) == 0)
				{
					p = false;
					break;
				}
			}
			if(p) primes.add(i);
		}
		return primes;
	}
}
