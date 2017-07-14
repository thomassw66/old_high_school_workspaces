/*
ID: thomass1
LANG: JAVA
TASK: gift1
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
public class gift1 {

	public static void main(String p[]) throws IOException{
		BufferedReader read = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new FileWriter("gift1.out"));
		int a = Integer.parseInt(read.readLine());
		String [] list = new String[a];
		HashMap<String,Integer> accounts = new HashMap<String,Integer>();
		for(int i = 0; i < a; i++){
			list[i] = read.readLine();
			accounts.put(list[i],0);
		
		}
		for(int x = 0; x < a; x++){
			String name = read.readLine();
			String l = read.readLine();
			StringTokenizer chop = new StringTokenizer(l);
			int money = Integer.parseInt(chop.nextToken());
			int people = Integer.parseInt(chop.nextToken());
			if(people == 0)continue;
			money = money-money%people;
			accounts.put(name, accounts.get(name)-money);
			for(int i = 0; i< people; i++){
				String recieve = read.readLine();
				accounts.put(recieve, accounts.get(recieve)+money/people);
			}
		}
		for(String s:list){
			out.printf("%s %d\n",s,accounts.get(s));
		}
		out.close();
		System.exit(0);
	}
}
