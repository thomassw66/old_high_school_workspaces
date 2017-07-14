
public class Primes {

	public static void main(String [] argsdfsadf){
		long st = System.currentTimeMillis();
		int p = 3;
		int primes = 2;
		while(primes < 1000000){
			p += 2;
			boolean primeflag = true; // innocent until proven guilty
			int s =	(int)Math.ceil(Math.sqrt(p));
			for(int i = 2; i < s; i++){
				if (p % i == 0){
					primeflag = false;
					break;
				}
			}
			if(primeflag)primes++;
		}
		long e = System.currentTimeMillis();
		System.out.println(e - st + " milliseconds");
		System.out.println(p);
	}
}
