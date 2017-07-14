import java.io.File;
import java.util.Scanner;


public class E {
	public static void main(String[] args) throws Exception{
		int[] dMax = {0,1,2,4,6,9,12,16,20,25,30};
		Scanner in = new Scanner(new File("E.txt"));
		int cases = in.nextInt();
		for(int i = 0; i< cases; i++){
			char c = in.next().charAt(0);
			int bw = in.nextInt();
			int bh = in.nextInt();
			
			switch(c){
				case 'k':
					int ks = bh * bw / 2;
					System.out.println(ks);
					break;
				case 'Q':
					System.out.println(Math.max(bw, bh));
					break;
				case 'K':
					int aq = (bw /2) * (bh / 2);
					System.out.println(aq);
					break;
			}
		}
	}
}
