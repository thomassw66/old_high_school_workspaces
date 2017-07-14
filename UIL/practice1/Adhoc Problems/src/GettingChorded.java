import java.util.Arrays;
import java.util.Scanner;


public class GettingChorded {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while(in.hasNextLine()){
			String [] chord = new String [3];
			chord[0] = in.next();
			chord[1] = in.next();
			chord[2] = in.next(); in.nextLine();
			
			int [] values = new int[3];
			for(int i = 0; i < values.length; i++){
				values[i] = getIndex(chord[i]);
			}
			int m = isMinor(values);
			int M = isMajor(values);
			

			//print(values);
			print(chord);
			if(M != -1){
				
				System.out.printf("is a %s Major chord.\n", notes[values[M]].toUpperCase());
			}else if (m != -1){
				
				System.out.printf("is a %s Minor chord.\n", notes[values[m]].toUpperCase());
			}else{

				System.out.println("is unrecognized.");
			}
		}
	}
	static void print(String [] a){
		for(String s : a)
			System.out.print(s + " ");
	}
	static void print(int [] a){
		for(int s : a)
			System.out.print(s + " ");
	}
	static int isMajor(int [] indexes){
		for(int i = 0; i < indexes.length; i++){
			int ours = indexes[i];
			int a = indexes[(i+1) %indexes.length];
			int b = indexes[(i+2) %indexes.length];

			if((a == (ours+4)% notes.length)&&(b == (ours+7)% notes.length)){
				return i;
			}
			if((b == (ours+4)% notes.length)&&(a == (ours+7)% notes.length)){
				return i;
			}
		}
		return -1;
	}
	static int isMinor(int [] indexes){
		for(int i = 0; i < indexes.length; i++){
			int ours = indexes[i];
			int a = indexes[(i+1) %indexes.length];
			int b = indexes[(i+2) %indexes.length];
			
			if((a == (ours+3)% notes.length)&&(b == (ours+7)% notes.length)){
				return i;
			}
			if((b == (ours+3)% notes.length)&&(a == (ours+7)% notes.length)){
				return i;
			}
		}
		return -1;
	}
	static int getIndex(String note){
		note = note.toLowerCase();
		char a = note.charAt(0);
		String ret = "";
		if(note.length() > 1){
			if(note.charAt(1) == 'b'){
				ret += ""+(char)((((a - 'a')+6)%7)+'a');
				ret += "#";
			}else{
				ret+= a;
				ret+="#";
			}
		}
		else{
			ret += a;
		}
		return indexOf(ret);
	}
	static int indexOf(String s){
		for(int i = 0; i < notes.length; i++)
			if(s.equals(notes[i]))
				return i;
		return -1;
	}
	static String [] notes = {"c","c#","d","d#","e","f", "f#","g","g#","a","a#","b"};
}
