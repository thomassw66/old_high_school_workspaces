
public class FaroShuffle {

	public static void main(String [] args){
		int [] a = new int [52];
		for(int i = 0; i < 52; i++){
			a[i] = i;
		}
		faro(a);
	}
	public static void faro(int [] a){
		int [] b = new int [a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		System.out.println(a[5] + " " + b[7] + " ");
	}
}
