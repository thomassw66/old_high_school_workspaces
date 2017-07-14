import java.io.*;
import java.util.StringTokenizer;

public class photo {

	public static void main (String p[]) throws IOException{
		BufferedReader read = new BufferedReader (new InputStreamReader(System.in));
		StringBuffer input = new StringBuffer(10000);
		int n;
		while((n=read.read())>0)input.append((char)n);
		StringTokenizer chop = new StringTokenizer(input.toString());
		
		int COWS = Integer.parseInt(chop.nextToken());
		int PHOTOS = Integer.parseInt(chop.nextToken());
		
		boolean isCowSpotted [] = new boolean[COWS+1];
	}
}
