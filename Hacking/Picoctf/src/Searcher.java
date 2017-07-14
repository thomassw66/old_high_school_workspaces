import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Searcher {

	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Thomas\\Downloads\\spamcarver.jpg"));
		StringBuffer s = new StringBuffer(10000000);
		int i = -1;
		while((i=in.read()) != -1){
			s.append((char) i);
		}
		String myString = s.toString();
		System.out.println(myString);
	}
}
