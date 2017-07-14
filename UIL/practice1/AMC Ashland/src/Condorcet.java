import java.util.Scanner;


public class Condorcet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int ballots = in.nextInt();//read # of ballots 
		
		int canidates = in.nextInt();// read # of canidets
		
		in.nextLine(); // clear rest of line
		
		int cases = 1;
		
		//while not 0 0 
		while(canidates + ballots != 0){
			//keep canidates score
			int [] canidatesScores = new int [canidates];
			
			//go through each ballot incrementing the score for each canidate
			for(int i = 0; i < ballots; i++){
				//for each canidate on ballot
				for(int j = canidates; j > 0; j--){
					int s = in.nextInt();
					canidatesScores[s] += j;
				}
				in.nextLine(); // clear rest of line
			}
			boolean noWinner = false; //to make sure there are no ties
			
			int max = 0;
			int mp = -1;
			
			//find canidate with most points
			for(int i = 0; i < canidates; i++){
				int x = canidatesScores[i];
				if(x == max){
					noWinner = true;
					continue;
				}else if (x > max){
					noWinner = false;
					max = x;
					mp = i;
				}
			}
			System.out.print("Case #"+cases++ +": ");
			if(noWinner)
				System.out.println("No Condorcet winner");
			else
				System.out.println(mp);
			

			ballots = in.nextInt();//read # of ballots 
			canidates = in.nextInt();// read # of canidets
		}
	}

}
