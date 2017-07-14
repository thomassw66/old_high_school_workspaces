import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class B {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner (new File("B.txt"));
		
		int devices = in.nextInt();
		int ops = in.nextInt();
		int maxVoltage = in.nextInt();
		in.nextLine();
		int cases = 1;
		while(devices != 0 && ops != 0 && maxVoltage != 0){
			System.out.println("Sequence "+ cases++);
			//System.out.println("*******" + devices+" ");
			int devs[] = new int[devices];
			boolean [] on = new boolean[devices];
			for(int i = 0; i < devices; i++){
				devs[i] = in.nextInt();
				//System.out.println(devs[i]);
				in.nextLine();
			}
			boolean broke = false;
			int max = 0;
			int sum = 0;
			for(int i = 0; i < ops; i++){
				//if they say 1 it means 0
				int whichDevice = in.nextInt() - 1;
				in.nextLine();
				//System.out.println(i +"Device #"+ whichDevice + " of " + devices);
				//if the d on turn off other wise turn on
				if(on [whichDevice]){
					sum -= devs[whichDevice];
					//System.out.println("Device " + whichDevice + " turns off");
				}else{
					sum += devs[whichDevice];
					//System.out.println("Device " + whichDevice + " turns on");
					if(sum > max){
						max = sum;
					}
				}
				//toggle on/off
				on[whichDevice] = !on[whichDevice];
				if(sum > maxVoltage){
					broke = true;
				}
			}
			if(broke){
				System.out.println("Breaker was tripped.");
			}else{
				System.out.println("Breaker was not tripped.");
				System.out.println("Maximal power consumption was "+ max +" amperes.");
			}
			System.out.println();
			devices = in.nextInt();
			ops =in.nextInt();
			maxVoltage = in.nextInt();
			in.nextLine();
		}
		
	}

}
