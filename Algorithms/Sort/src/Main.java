import java.io.PrintStream;


public class Main {

	static PrintStream o = System.out;
	public static void main(String [] args){
		int i = 10;
		o.println((1<<31) - 1);
		o.println(Integer.MAX_VALUE);
		o.println(Integer.numberOfLeadingZeros((1 << 31) - 1));
	}
}
