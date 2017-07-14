import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decoder {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int s;
		while((s = in.read()) != -1){
			char c = (char) s;
			System.out.println(c - 7);
		}
	}
}