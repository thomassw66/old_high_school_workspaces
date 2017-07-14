/*
ID: thomass1
LANG: JAVA
TASK: ride
*/


import java.io.*;
import java.util.*;

public class ride {

	public static void main(String [] a) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new FileWriter("ride.out"));
		out.println(fromString(f.readLine())%47==fromString(f.readLine())%47?"GO":"STAY");
		out.close();
		System.exit(0);
	}
	static int fromString(String s){
		int product = 1;
		for(int i = 0; i < s.length(); i++)
			product *= s.charAt(i) - 'A' + 1;
		return product;
	}
}
