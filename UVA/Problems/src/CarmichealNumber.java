import java.math.BigInteger;


public class CarmichealNumber {

	public static void main(String []args){
		BigInteger b = BigInteger.valueOf(17);
		int i = 2;
		while(i < 17){
			System.out.println(b.mod(BigInteger.valueOf(i))+" "+b.modPow(BigInteger.valueOf(i),BigInteger.valueOf(i)));
			i++;
		}
		System.out.println(i);
	}
}
