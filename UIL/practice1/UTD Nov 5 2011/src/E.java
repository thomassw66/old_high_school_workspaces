import java.util.Scanner;


public class E {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		int n = in.nextInt(); // number of cases
		in.nextLine();
		for(int i = 0; i < n; i++){
			String t = in.next();
			int l = in.nextInt();
			in.nextLine();
			
			int c;
			if(t.equals("TRIANGLE")){
				c = triangle(l);
			}else{
				c = square(l);
			}
			
			System.out.println("The number of cannonballs is " + c);
		}
	}
	static int square(int layers){
		if(layers > 1)
			return(square(layers - 1) + layers*layers);
		else return 1;
	}
	static int triangle(int layers){
		if(layers > 1)
			return triangle (layers - 1) + (layers * (layers + 1)) / 2;
		return 1;
	}
}
