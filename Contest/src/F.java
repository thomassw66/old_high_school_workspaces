import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class F {
	public static void main(String [] sdfasdfa)throws Exception{
		Scanner in = new Scanner (new File("F.txt"));
		
		int partmants = in.nextInt();
		while(partmants != 0){
			ArrayList<App> dists = new ArrayList <App>();
			for(int i = 1; i <= partmants; i++ ){
				int d = in.nextInt();
				int c = in.nextInt();
				for(int j = 0;j < c; j++){
					dists.add(new App(i,d));
				}
				in.nextLine();
			}
			Collections.sort(dists);
			int median = dists.size()/2;
			while(median > 0 && dists.get(median).dist == dists.get(median-1).dist){
				median --;
			}
			System.out.println("The surgery should be in building " + dists.get(median).aptNum);
			System.out.printf("The average distance to the surgery is %.2f\n", aveDist(dists.get(median).dist,dists) );
			partmants = in.nextInt();
			in.nextLine();
		}
	} 
	static double aveDist(int d,ArrayList<App> t){
		double sum = 0;
		int i = 0;
		for(App a: t){
			sum += Math.abs(a.dist - d);
			i++;
		}
		return sum / i;
	}
}
class App implements Comparable<App>{
	int aptNum;
	int dist;
	public App(int appNum,int dist){
		this.aptNum = appNum;
		this.dist = dist;
	}
	public int compareTo(App a){
		int i = this.dist - a.dist;
		if(i != 0)
			return i;
		return aptNum - a.aptNum;
	}
}
