import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class KPRIME {

	static int [] kprime = new int [100001];
	public static void main(String [] args) throws IOException{
		for(int i = 2;i <= 100000; i++){
			if (kprime[i]==0){//its prime
				int m = i;
				do{
					kprime[m]++;
					m += i;
				}while(m <= 100000);
			}
		}
		
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		int c = nextInt(in);
		for(int i = 0; i < c; i++){
			int b = nextInt(in);
			int e = nextInt(in);
			int k = nextInt(in);
			int count = 0;
			for(int j = b; j <= e; j++){
				if(kprime[j]==k){
					count++;
				}
			}
			System.out.println(count);
		}
	}
	static int nextInt(BufferedReader in) throws IOException{
		char c = (char) in.read();
		while(!(c >= '0' && c <= '9'))
			c = (char) in.read();
		int n = c - '0';
		while(Character.isDigit((c = (char) in.read())))
				n = n * 10 + c - '0';
		return n;
	}
}
