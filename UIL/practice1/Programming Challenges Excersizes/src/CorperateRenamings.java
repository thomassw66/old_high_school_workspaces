import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CorperateRenamings {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static String [][] mergers;
	static int changes;
	
	static void readChanges() throws Exception{
		changes = Integer.parseInt(in.readLine());
		mergers = new String [changes][2];
		for(int i = 0; i < changes; i++){
			mergers[i][0] = readQuote();
			mergers[i][1] = readQuote();
			in.readLine();
		}
	}
	static void replaceAll(StringBuffer nText, String pattern, String repl){
		int ind;
		while((ind = nText.indexOf(pattern)) != -1){
			nText.replace(ind, ind + pattern.length(), repl);
		}
	}
	static String readQuote() throws IOException{
		char c;
		StringBuffer s = new StringBuffer();
		while((c = (char)in.read()) != '"');
		while((c = (char)in.read()) != '"'){
			s.append(c);
		}
		return s.toString();
	}
	
	public static void main(String p[]) throws Exception{
		readChanges();
		//System.out.println(Arrays.deepToString(mergers));
		int nLines = Integer.parseInt(in.readLine());
		for(int i = 0; i < nLines; i++){
			StringBuffer text = new StringBuffer(in.readLine());
			for(int j = 0; j < changes; j++){
				replaceAll(text, mergers[j][0], mergers[j][1]);
			}
			System.out.println(text);
		}
	}
}
