import java.util.Scanner;


public class CatsAndHats {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		
		int a,b;
		while((a = in.nextInt()) != 0 && (b = in.nextInt()) != 0){
			if(a == 1 && b == 1){ 
				// algorithm wont work in this case because of divide by zero
				System.out.println("0 1"); // easy to see the answer for this case
				continue;
			}
			double i = a,j = b;
			int x;//xponent
			double t1,t2;
			for(x = 1; x < 200; x++){
				t1 = Math.pow(i, 1.0 / x);
				t2 = Math.pow(j, 1.0 / x);
				
				if(Math.abs(t1 - t2 - 1) < .00001){
					i = Math.round(t1);
					j = Math.round(t2);
					break;
				}
			}
			//System.out.println(i + " " + j + " " + x);
			int sum = 0;
			int totalH = 0;
			int cats = 1;
			int h = a;
			int r = (int)i;
			for(int k = 0; k < x; k++){
				sum += cats;
				totalH += cats * h;
				cats *= j;
				h /= r;
			}
			totalH += cats * h;
			System.out.println(sum + " " + totalH);
		}
		in.close();
	}
}
