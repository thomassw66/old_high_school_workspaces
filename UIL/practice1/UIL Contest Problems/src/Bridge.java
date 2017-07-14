import java.io.File;
import java.util.Scanner;


public class Bridge {

	static int TRUCKS;
	static int trucksAllocated;
	
	static int weights[];
	static int speeds[];
	static int group[];
	
	static int MAXWEIGHT = 42;
	//static int MAXTIME;
	
	
	public static void main(String [] args)throws Exception{
		// Create a new scanner
        Scanner input = new Scanner(new File("bridge.dat"));

        // Get the number of data sets
        int numSets = input.nextInt(); 
        input.nextLine();

        // Now process each data set
        for (int ds = 0; ds < numSets; ds++) {

            // read in the convoy size
            TRUCKS = input.nextInt(); 

            // read in the convoy weights
            weights = new int[TRUCKS];
            speeds   = new int[TRUCKS];
            group  = new int[TRUCKS];
            for (int i = 0; i < TRUCKS; i++) {
               weights[i] = input.nextInt();
               speeds[i] = input.nextInt();
               group[i] = -1; // means this truck is unassigned
            }
            input.nextLine();

            // now lets find the best-case scenario
            //the placement of the first truck should not matter, this will effectively divide runtime by n
            group[0] = 1;
            System.out.println(depthFirstSolution(1,1,weights[0], speeds[0],0));

        }
        input.close();
	}
	static int depthFirstSolution(int truck,int groupNum,int groupWeight, int groupTime, int totalTime){
		
		//we have already gone through all of our trucks
		if(truck >= TRUCKS)
			return totalTime + groupTime;
		
		int bestSolution = Integer.MAX_VALUE;
		
		for(int i = 0; i < TRUCKS; i ++)
		{
			int NEWGROUP 		= 		groupNum;
			int NEWWEIGHT 		= 	  groupWeight;
			int NEWGROUPTIME 	= 		groupTime;
			int NEWTOTALTIME 	= 		totalTime;
			
			if(group[i] != -1)
				continue;
			
			//truck is to big to be in this group
			if(groupWeight + weights[i] > MAXWEIGHT){
				
				NEWGROUP++;
				NEWWEIGHT = weights[i];
				NEWTOTALTIME += groupTime;
				NEWGROUPTIME = speeds[i];
				
			}else{
				//otherwise we add truck to current group
				NEWWEIGHT += weights[i];
				NEWGROUPTIME = Math.max(speeds[i], groupTime);
				
			}

			group[i] = NEWGROUP;
			
			//System.out.println("depth = "+truck + " time-so-far = " + (NEWTOTALTIME+NEWGROUPTIME));
			int solution = depthFirstSolution(truck + 1, NEWGROUP, NEWWEIGHT, NEWGROUPTIME, NEWTOTALTIME);
			
			if(solution < bestSolution){
				bestSolution = solution;
			}
			group[i] = -1;
		}
		return bestSolution;
	}
}
