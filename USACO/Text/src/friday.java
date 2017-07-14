/*
ID: thomass1
LANG: JAVA
TASK: friday
 */

import java.io.*;
import java.util.Arrays;
public class friday {

	public static void main(String [] args) throws IOException{
		int [] days_in_month = {31,28,31,30,31,30,31,31,30,31,30,31};
		int []thirteenths = new int [7]; //SU M T W TH F S 
		PrintWriter out = new PrintWriter(new FileWriter("friday.out"));
		BufferedReader in = new BufferedReader(new FileReader("friday.in"));
		int N = Integer.parseInt(in.readLine());
		
		int daysPassed = 0;//jan 1 1900 Monday
		for (int year = 1900; year < 1900+N; year++){
			
			for(int month = 0; month < 12; month++){
				daysPassed += 13;
				thirteenths[daysPassed%7]++;
				daysPassed += days_in_month[month] - 13;
				if(month == 1 && isLeapYear(year))daysPassed++;
			}
		}
		out.print(thirteenths[thirteenths.length - 1]);
		for(int i = 0; i < thirteenths.length - 1; i++){
			out.print(" " + thirteenths[i]);
		}
		out.print("\n");
		out.close();
		System.exit(0);
	}
	static boolean isLeapYear(int year){
		return ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0));
	}

}
