import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;


public class ExtraRemover {

	public static void main(String [] args){
		ArrayList<String> t = new ArrayList<String>();
		Scanner in = new Scanner (System.in);
		String [] s = in.nextLine().split("\\s");
		for(String l : s){
			if(t.indexOf(l) == -1)
				t.add(l);
		}
		Collections.sort(t);
		System.out.println(t.size() + " " + s.length);
		for(String str : t){
			System.out.print(str+" ");
		}
	}
}
