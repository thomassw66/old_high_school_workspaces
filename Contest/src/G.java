import java.io.File;
import java.util.Scanner;


public class G {

	public static void main(String [] sdfasdfa)throws Exception{
		Scanner in = new Scanner (new File("G.txt"));
		int times = in.nextInt();
		for(int i = 0; i < times;i++){
			int j = in.nextInt()+1;
			System.out.println(j*j -1);
		}
	}
}
