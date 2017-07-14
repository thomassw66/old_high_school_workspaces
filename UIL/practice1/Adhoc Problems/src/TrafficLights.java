import java.util.LinkedList;
import java.util.Scanner;


public class TrafficLights {


	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);

		int num_consequetive_zeros = 0;
		while(num_consequetive_zeros < 3){
			LinkedList<Integer> l = new LinkedList<Integer>();
			int last = in.nextInt();
			while(last != 0){
				num_consequetive_zeros = 0;
				l.add(last);
				last = in.nextInt();
			}
			if(l.size() > 1){
				//then well process the input
				int LIGHTS = l.size();
				Integer [] cycleTimes = l.toArray( new Integer[LIGHTS]);
				int [] secondsLeft = new int[LIGHTS];
				boolean [] on = new boolean [LIGHTS];
				
				int seconds = 0;
				
				for(int i = 0; i < LIGHTS; i++){
					on[i] = true;
					//five seconds will be orange
					secondsLeft[i] = cycleTimes[i] - 5;
				}
				while(true){
					 int nextChange = min(secondsLeft);

					for(int x = 0; x < LIGHTS; x++)
						secondsLeft[x] -= nextChange;
					
					seconds+=nextChange;
					//5 hours is 18000 seconds 5 * 60 * 60
					if(seconds > 18000){
						System.out.println("Signals fail to synchronise in 5 hours");
						break;
					}
					for(int x = 0; x < LIGHTS;x++){
						if(secondsLeft[x] <= 0){
							if(on[x]){
								secondsLeft[x] = secondsLeft[x] + cycleTimes[x] + 5;
							}else{
								secondsLeft[x] = secondsLeft[x] + cycleTimes[x] - 5;
							}
							on[x] = !on[x];

							//System.out.println(x+" just turned " + (on[x]? "on" : "off")+": " + toTime(seconds) + " s");
						}
						
					}
					
					//System.out.println("It is " + (and(on)? "" : "not ") + "a solution");
					if(and(on))
					{
						System.out.println(toTime(seconds));
						break;
					}
				}
				
			}
			num_consequetive_zeros++;
		}
		
	}
	static boolean and(boolean[] b){
		for(int i = 0; i < b.length; i++)
			if(!b[i])
				return false;
		return true;
	}
	static String toTime(int s){
		return String.format("%02d:%02d:%02d", s/3600, ((s%3600) / 60), s % 60);
	}
	static int min(int [] a){
		int min = a[0]; 
		for(int i = 1; i < a.length; i++){
			if(a[i] < min)
				min = a[i];
		}
		return min;
	}
}
