import java.util.Scanner;


public class GohperDog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			int HOLES = in.nextInt();
			
			double gx = in.nextDouble();
			double gy = in.nextDouble();
			double dx = in.nextDouble();
			double dy = in.nextDouble();
			
			in.nextLine();
			
			double  hole [][] = new double [HOLES][2];
			
			int index = -1;
			
			for(int i = 0; i < HOLES; i++){
				hole[i][0] = in.nextDouble();
				hole[i][1] = in.nextDouble();
				
				in.nextLine();
				//the gopher the distance between the gopher is less than half that of the dog
				if(4 * distSquared(gx,gy,hole[i][0],hole[i][1]) < distSquared(dx,dy,hole[i][0],hole[i][1])){
					System.out.printf("The gopher can escape through the hole at (%.03f, %.03f)\n",hole[i][0],hole[i][1]);
					index = 1;
					break;
				}
			}
			if(index == -1){
				System.out.println("The gopher cannot escape");
			}
			in.nextLine();
		}
		 
	}
	static double distSquared(double x, double y, double x2, double y2){
		return (x - x2) * (x - x2) + (y - y2) * (y - y2);
	}
}
