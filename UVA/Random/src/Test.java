
public class Test {

	public static void main(String []args){
		long s = System.currentTimeMillis();
		int [] a = new int[200000000];
		for(int i = 0; i < 200000000; i++){
		a[i] = i;
		}
		System.out.println("hello " + (System.currentTimeMillis() - s));
	}
}
