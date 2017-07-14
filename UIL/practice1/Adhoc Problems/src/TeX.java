import java.util.Scanner;


public class TeX {

	static boolean firstQuote = true;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){
			System.out.println(toTex(in.nextLine()));
		}
	}
	public static String toTex(String orig){
		String ret = "";
		for(int i = 0; i < orig.length(); i ++){
			char c = orig.charAt(i);
			if(c == '"'){
				if(firstQuote){
					ret += "``";
				}else{
					ret += "''";
				}
				firstQuote = !firstQuote;
			}else{
				ret += c;
			}
		}
		return ret;
	}
}
