import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Pool {

	/**
	 * @param args
	 */
	static ArrayList<Integer> trinums;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trinums = new ArrayList<Integer>(10000);
		trinums.add(1);
		
		Scanner in = new Scanner (System.in);
		
		int l = in.nextInt();
		int h = in.nextInt();
		in.nextLine();
		
		int cases = 1;
		
		while(l+h != 0){
			int rackables = 0;
			for(int i = l +1; i < h; i++){
				if(canBeRacked(i))
					rackables++;
			}
			System.out.println("Case #"+cases++ + ": "+rackables);
			
			l = in.nextInt();
			h = in.nextInt();
			in.nextLine();
		}
	}
	static void buildPast(int number){
		while(trinums.get(trinums.size()-1) <= number){
			trinums.add(trinums.get(trinums.size()-1) + trinums.size() + 1);
		}
	}
	//can it be racked
	static boolean canBeRacked(int x){
		//if its a perfect square
		if(perfectSquare(x)){
			buildPast(x-1);//so we have enough trinums
			
			int result = Collections.binarySearch(trinums, x - 1);
			return result >= 0; // if its in the triangle numbers
		}else return false;
	}
	
	//tested works
	static boolean perfectSquare(int x){
		double sqx = Math.sqrt(x);
		return (((double)Math.round(sqx)) == sqx);
	}
}
