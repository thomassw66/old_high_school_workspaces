import java.math.BigInteger;

public class IntegerAtom extends AtomExpression{
	BigInteger self;
	public IntegerAtom(String number){
		self = new BigInteger(number);
	}
	public String toString(){
		return self.toString();
	}
}
