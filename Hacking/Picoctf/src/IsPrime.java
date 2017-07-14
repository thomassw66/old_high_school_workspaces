import java.math.BigInteger;


public class IsPrime {

	public static void main(String [] p){
		BigInteger b = new BigInteger("16479872267971488946354763301140972522015419337116705512467247271354034756750385463052350038749622405290902966721390808831833066792256193");
		BigInteger n = BigInteger.valueOf(3160413);
		BigInteger t = BigInteger.valueOf(2);
		while(b.compareTo(BigInteger.ONE) > 0){
			if(b.mod(n).equals(BigInteger.ZERO)){
				System.out.print(n);
				break;
			}
			n = n.add(t);
		}
	}
}
