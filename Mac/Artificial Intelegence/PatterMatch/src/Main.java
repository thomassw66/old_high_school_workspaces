import java.util.ArrayList;


public class Main {

	public static void main(String [] args ){
		
	}
	Object [] parse(String toparse){
		assert(toparse.charAt(0) == '[');
		ArrayList ret = new ArrayList();
		int index = 1;
		while(index < toparse.length()-1){
			switch(toparse.charAt(index)){
			case '[':
				int bcount = 1;
				int j = index+1;
				
				// when complete substr(index,j) will return the string we want
				while(bcount > 0){ 
					switch(toparse.charAt(j)){
					case '[': 
						bcount ++;
						break;
					case ']': 
						bcount --;
						break;
					}
					j++;
				}
				ret.add(parse(toparse.substring(index,j)));
			}
		}
		return null;
	}
	boolean isValid(char c){
		return c == '+' || c == '-' || c == '/' || c == '*' || c == '^';
	}
	boolean isNum(char c){
		return c <= '9' && c >= '0';
	}
	boolean isAlph(char c){
		return c <= 'z' && c >= 'a' || c >= 'A' && c <= 'Z';
	}
}
