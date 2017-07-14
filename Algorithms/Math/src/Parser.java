
public class Parser {
	static char look;
	String s;
	int index;
	
	public Parser(String expression){
		s = expression;
		index = 0;
	}
	char getNext() throws StringIndexOutOfBoundsException{
		if(index >= s.length()) return Character.MAX_VALUE;
		return s.charAt(index++);
	}
	void back(){
		index--;
	}
	boolean isDigit(char c){
		return c <= '9' && c >= '0';
	}
	boolean isLetterLower(char c){
		return c >= 'a' && c <= 'z';
	}
	boolean isLetterUpper(char c){
		return c >= 'A' && c <= 'Z';
	}
	boolean isLetter(char c){
		return isLetterLower(c) || isLetterUpper(c);
	}
	int getNum(){
		String a = "";
		char c = getNext();
		while(isDigit(c)){
			a += c;
			c = getNext();
		}
		back();
		return Integer.parseInt(a);
	}
	void skipSpace(){
		char c = getNext();
		while(c == ' ')c = getNext();
		back();
	}
	int factor(){
		skipSpace();
		char c = getNext();
		if(c == '('){
			int i = 1;
			String str = "";
			while(true){
				char p = getNext();
				
				if(p == ')')
					i--;
				if(p == '(')
					i++;
				
				if(i <= 0){
					break;
				}else {
					str += p;
					System.out.println(str);
				}
			}
			Parser p = new Parser(str);
			return p.parse();
		}
		back();
		return getNum();
	}
	int term(){
		skipSpace();
		int a = factor();
		skipSpace();
		char c = getNext();
		while(c == '*' || c == '/'){
			switch(c){
			case '*':
				a *= factor();
				break;
			case '/':
				a /= factor();
				break;
			}
			skipSpace();
			c = getNext();
		}
		back();
		return a;
	}
	int parse(){
		System.out.println(s);
		int a = term();
		
		skipSpace();
		char op = getNext();
		
		while(op == '+' || op == '-'){
			switch(op){
			case '+':
				a += term();
				break;
			case '-':
				a -= term();
				break;
			}
			skipSpace();
			op = getNext();
		}
		back();
		
		return a;
	}
	public static void main(String [] args){
		Parser p = new Parser("(1+40000/(10*4*100))*9");
		System.out.println(p.parse());
	}
}
