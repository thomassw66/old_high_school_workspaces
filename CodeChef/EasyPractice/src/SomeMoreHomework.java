
public class SomeMoreHomework {

	public static void main(String [] args){
		for(int i = 0; i < 16; i++){
			System.out.print(bn(i));
		}
	}
	static int bn(int n){
		int number_1_bits = 0;
		while(n > 0){
			number_1_bits += n & 1;
			n /= 2;
		}
		return number_1_bits % 2;
	}
}
