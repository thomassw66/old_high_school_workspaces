import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class PathPossible {

	public static void main(String [] args ){
		//Scanner in = new Scanner (System.in);
		
		HashSet<Integer> b = new HashSet<Integer>();
		b.add(1*64+3);		
		b.add(3*64 + 2);
		System.out.println(b);
		System.out.println(b.contains(1*64+3));
	}
}
class Tuple {
	int a;
	int b;
	public Tuple(int a,int b){
		this.a = a;
		this.b = b;
	}
	public String toString(){
		return "("+a+"=>"+b+")";
	}
}