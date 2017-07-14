
public class PatternParser {
	String raw;
	int index;
	public PatternParser(String s){
		raw = s;
		index = 0;
	}
	void skipSpace(){
		while(Character.isWhitespace(raw.charAt(index)))
			index++;
	}
	IntegerAtom getNum(){
		char c;
		String s = "";
		while(Character.isDigit(c = raw.charAt(index))){
			s+=c;
			index++; 
		}
		return new IntegerAtom(s);
	}
	SExpression get(){
		skipSpace();
		System.out.println(index);
		char c = raw.charAt(index);
		if(c == '('){
			return listExpression();
		}else {
			return getNum();
		}
	}
	public ListExpression listExpression(){
		assert(raw.charAt(index) == '(');
		ListExpression list = new ListExpression();
		index ++;		
		skipSpace();
		while(raw.charAt(index) != ')'){ 
			list.expressions.add(get());			
			skipSpace();
		}
		index++;
		return list;
	}
	public static void main(String []args){
		PatternParser p = new PatternParser("(1 2 (1) (1 3 (13 3) 5))");
		System.out.println("highbeg");
		SExpression a = p.get();
		System.out.println("highend");
		System.out.println(a);
	}
}
