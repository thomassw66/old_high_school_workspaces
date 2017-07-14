import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Marbles {
	static void allPosible(int marbles,int n1,int c1,int n2, int c2){
		int min = Integer.MAX_VALUE,min1=-1,min2=-1;
		int one;
		for(one = 0; marbles >= 0; one++,marbles -= n1){
			if(marbles % n2 == 0){
				int two = marbles / n2;
				int cost = one * c1 + two * c2;
				//System.out.println(one + " " + two);
				//System.out.println(cost);
				if(cost < min){
					min1 = one;
					min2 = two;
					min = cost;
				}
			}
		}
		if(min != Integer.MAX_VALUE){
			System.out.println(min1 + " " +min2);
		}else{
			System.out.println("failed");
		}
	}
	static boolean digit(char c){
		return (c <= '9' && c >= '0');
	}
	static int getInt(BufferedReader n) throws IOException{
		char c = (char)n.read();
		while(!digit(c))c = (char)n.read();
		int a = 0;
		while(digit(c)) {
			a *= 10;
			a += c - '0';
			c = (char)n.read();
		}
		return a;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		int marbles;
		while((marbles = getInt(in)) != 0){
			int c1 = getInt(in);
			int n1 = getInt(in);
			int c2 = getInt(in);
			int n2 = getInt(in);
			allPosible(marbles,n1,c1,n2,c2);
		}
	}

}
