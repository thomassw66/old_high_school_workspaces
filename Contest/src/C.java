import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class C {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner (new File("C.txt"));
		int sets = in.nextInt();
		in.nextLine();
		for (int i = 0; i < sets; i++) {
			String specs[] = in.nextLine().split(" ");
			int distance = Integer.parseInt(specs[0]);
			int speed = Integer.parseInt(specs[2]);
			//System.out.println(speed);
			String departure = specs[1].split(",")[0];
			int departureMin = tToMinutes(departure);
			if (departureMin <= 720) {
				//departureMin += 720;
			}
			double initialEta = (double)distance/(double)speed * 60;
			
			int numAlerts = in.nextInt();
			in.nextLine();
			for (int j = 0; j < numAlerts; j++) {
				String junk[] = in.nextLine().split(" ");
				String alertTime = junk[2].split(",")[0];
				int dist = Integer.parseInt(junk[3].split("m")[0]);
				int delay = Integer.parseInt(junk[7]);
				//System.out.println(alertTime + " " + dist + " " + delay);
				//System.out.println(tToMinutes(alertTime)); 
				int alertTimeMin = tToMinutes(alertTime);
				if (alertTimeMin < 720) {
					//alertTimeMin += 720;
				}
				//System.out.println(alertTimeMin + "  " + departureMin);
				int sinceDeparture = alertTimeMin - departureMin;
				//System.out.println(sinceDeparture);
				double alreadyTrav = (double)sinceDeparture/60.0 * (double)speed;
				//System.out.println(alreadyTrav);
				if (dist >= alreadyTrav) {
					initialEta += delay;
				}
			}
			System.out.println("Grandma's ETA " + ts(initialEta));
		}
	}
	static String ts(double min){
		String a = ""+(int)(min/60);
		String b = "" + ((int)(min%60));
		if(a.length() < 2)
			a = '0' + a;
		if(b.length() < 2)
				b = '0' + b;
		return a+":"+b;
	}
	
	static int tToMinutes(String s) {
		String[] nums = s.split(":");
		int hour = Integer.parseInt(nums[0]);
		int min = Integer.parseInt(nums[1]);
		int hourm = hour * 60;
		return hourm + min;
	}
}
