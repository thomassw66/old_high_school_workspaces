import java.io.*;
public class LifeUniverseAndEveryThing {

	public static void main(String [] ags) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num;
		while(true){
			num = Integer.parseInt(in.readLine());
			if (num == 42)
				break;
			System.out.println(num);
		}
	}
}