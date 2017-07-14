/*
ID: thomass1
LANG: JAVA
TASK: namenum
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class namenum {

	public static void main(String p[]) throws IOException{
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		
		HashMap<Long, ArrayList<String>> map = new HashMap<Long, ArrayList<String>>();
		String s;
		while((s = dict.readLine()) != null){
			long a = convert(s);
			List list = map.get(a);
			if(list == null)
				map.put(a, new ArrayList<String>());
			map.get(a).add(s);
		}
		BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new FileWriter("namenum.out"));
		long a = Long.parseLong(in.readLine());
		ArrayList<String> list = map.get(a);
		if(list == null){
			out.println("NONE");
		}else{
			for(String str : list)
				out.println(str);
		}
		out.close();
		System.exit(0);
	}
	static long convert(String s){
		long x = 0;
		for(int i = 0; i < s.length(); i++ ){
			
			x *= 10;
			
			char c = s.charAt(i);
			switch(c){
			case 'A':
			case 'B':
			case 'C':
				x += 2;
				break;
			case 'D':
			case 'E':
			case 'F':
				x += 3;
				break;
			case 'G':
			case 'H':
			case 'I':
				x += 4;
				break;
			case 'J':
			case 'K':
			case 'L':
				x += 5;
				break;
			case 'M':
			case 'N':
			case 'O':
				x += 6;
				break;
			case 'P':
			case 'R':
			case 'S':
				x += 7;
				break;
			case 'T':
			case 'U':
			case 'V':
				x += 8;
				break;
			case 'W':
			case 'X':
			case 'Y':
				x += 9;
				break;
			}
		}
		return x;
	}
}
