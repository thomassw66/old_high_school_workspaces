
public class BigNumTest {

	public static void main(String [] args){
		BigNum a = new BigNum(100234);a.shift(20);
		BigNum b = new BigNum(043241111);
		System.out.println(a);
		System.out.println(BigNum.multiply(a,b));
		System.out.println(a);
		System.out.println(b);
		System.out.println(BigNum.subtract(a, b));
	}
}
