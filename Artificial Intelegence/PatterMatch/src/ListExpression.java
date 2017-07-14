import java.util.LinkedList;
import java.util.List;


public class ListExpression extends SExpression{
	List<SExpression> expressions;
	public ListExpression(){
		expressions = new LinkedList<SExpression>();
	}
	public String toString(){
		StringBuffer s = new StringBuffer("(");
		for(SExpression e : expressions){
			s.append(e.toString());
			s.append(" ");
		}
		s.setCharAt(s.length()-1, ')');
		return s.toString();
	}
}
