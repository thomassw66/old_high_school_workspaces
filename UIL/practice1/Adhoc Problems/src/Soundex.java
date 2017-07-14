
import java.util.Scanner;


public class Soundex {

	public static void main(String[] args) 
	{											//
		Scanner in = new Scanner (System.in);//
		char [] a = new char[46];init(a);
		print("NAME", 9, a);
		print("SOUNDEX CODE", 34, a);
		System.out.println(a);
		while(in.hasNextLine()){
			String name = in.nextLine();
			String soundex = generateSoundex(name);
			char [] b = new char [38];init(b);
			print(name, 9, b);
			print(soundex , 34, b);
			System.out.println(b);
		}
		char [] b = new char [32];init(b);
		print("END OF OUTPUT", 19, b);
		System.out.println(b);
	}
	static void init(char[] c){
		for(int i = 0; i < c.length; i++){
			c[i] = ' ';
		}
	}
	public static void print(String s, int col, char [] output){
		for(int i = 0; i < s.length(); i++){
			output[col + i] = s.charAt(i);
		}
	}
	static String generateSoundex(String name){
		String ret = "";
		
		char m = name.charAt(0);
		int last = getSoundexCode(m);
		
		ret += m;
		int [] indexing = new int[3];
		int index = 0;
		for(int i = 1; i < name.length() && index < 3; i++){
			m = name.charAt(i);
			int code = getSoundexCode(m);
			
			if(code == last){
				continue;
			}else{
				if(code != -1){
					indexing [index++] = code;
				}
				//update
				last = code;
			}
		}
		for(int i = 0;i < 3; i++){
			ret+= indexing[i];
		}
		return ret;
	}
	static int getSoundexCode(char c){
		switch(c){
		case 'B':
		case 'P':
		case 'F':
		case 'V':
			return 1;
		case 'C':
		case 'S':
		case 'K':
		case 'G':
		case 'J':
		case 'Q':
		case 'X':
		case 'Z':
			return 2;
		case 'D':
		case 'T':
			return 3;
		case 'L':
			return 4;
		case 'M':
		case 'N':
			return 5;
		case 'R':
			return 6;
			
		//negative one if its a letter not encoded
		default:
			return -1;
		}
	}
}
