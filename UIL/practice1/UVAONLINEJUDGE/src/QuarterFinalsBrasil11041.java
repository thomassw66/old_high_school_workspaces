import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class QuarterFinalsBrasil11041 {
	static char [] names = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f'};
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		//# of test cases
		int times = Integer.parseInt(in.nextLine());
		
		for(int i = 0; i < times; i++){
			int brackets = Integer.parseInt(in.nextLine());
			char myTeamName = in.nextLine().charAt(0);
			int myTeamRating = 0;
			
			//teams is always 2 ^ brackets
			int teams = 1 << brackets;
			
			//so we can order teams worst to best
			int [] ratings = new int [teams];
			//placeholder so we always play worst team
			ratings[0] = Integer.MIN_VALUE;
			
			//memory of names for certain team ratings
			HashMap<Integer,Memory> similarRatings = new HashMap<Integer,Memory>();
			
			int aKey = 0;
			//iterate through all other teams
			for(int a=1,index = 0; index < teams; a++, index++){
				int r = in.nextInt();
				
				ratings[a] = r;
				
				if(names[index] == 'A'){
					aKey = r;
				}
				//its our team
				if(names[index] == myTeamName){
					Memory m = new Memory();
					m.c = new ArrayList<Character>();
					m.used = null;
					
					m.c.add(myTeamName);
					
					similarRatings.put(Integer.MIN_VALUE, m);
					a--;
				}else{
					if(similarRatings.containsKey(r)){
						Memory m = similarRatings.get(r);
						m.c.add(names[index]);
						m.used.add(false);
					}else{
						//initialize this
						Memory m = new Memory();
						m.c = new ArrayList<Character>();
						m.used = new ArrayList<Boolean>();
						//put this name in it for later
						m.c.add(names[index]);
						m.used.add(false);
						//add to the memory
						similarRatings.put(r, m);
					}
				}

			}
			//clear the line for next pass
			in.nextLine();
			
			//order teams from worst to best ////excluding us
			Arrays.sort(ratings);
			
			System.out.println(Arrays.toString(ratings));
			System.out.println(similarRatings);
			
			ratings[0] = myTeamRating;
			
			//literally A
			char a = similarRatings.get(aKey).c.remove(0);
			
			int [] solutionRates = new int [teams];
			
			solutionRates[0] = aKey;
			String sol = "" + a;
			
			
		}
		
		in.close();
	}  
	Comparable min(Comparable [] a){
		Comparable m = a[0];
		for(int i = 0; i < a.length; i++){
			if(a[i].compareTo(a) < 0)
				m = a[i];
		}
		return m;
	}
}
class Node {
	char c;
	int val;
	int position;
	ArrayList<Integer> possible_subgroups;
	Node actual_subgroup;
}
class Memory{
	ArrayList<Character> c;
	ArrayList<Boolean> used;
	public String toString(){
		return c.toString();
	}
}
