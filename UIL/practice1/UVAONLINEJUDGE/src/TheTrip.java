import java.util.Scanner;


public class TheTrip {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int people; // number of people
		while((people = in.nextInt()) != 0){
			int [] spent = new int [people]; // tells us the amount everyone spent
			for(int i = 0 ; i < people; i++)
				spent [i] = (int) (in.nextDouble()*100);
			
			int ave = average(spent);
			int totsPos = 0,totsNeg = 0; //total money that must pass hands
			for(int i = 0 ; i < people; i++){
				if(spent[i] < ave){
					totsPos += ave - spent[i];
				}else{
					totsNeg += spent[i] - ave;
				}
			}
			System.out.printf("$%.2f\n",(double)Math.min(totsPos, totsNeg)/100);
		}
	}
	static int average(int [] a){
		int sum = 0; 
		for(int i = 0; i < a.length; i++)
			sum += a[i];
		return	(int)( ((double)sum / a.length)+.5); // round it the average so the difference is always 0 or 1
	}
}
