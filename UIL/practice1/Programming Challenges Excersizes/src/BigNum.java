
public class BigNum {
	static final int PRECISION = 100;
	static final BigNum ONE = new BigNum(1);
	static final BigNum ZERO = new BigNum(0);
	
	int [] digits;
	int lastDigit;
	
	private BigNum(){
		digits = new int[PRECISION];
		lastDigit = PRECISION - 1;
	}
	public BigNum(int a){
		this();
		int i = 0;
		while(a > 0){
			digits[i++] = a % 10;
			a /= 10;
		}
		zeroJustify();
	}
	static BigNum multiply(BigNum a, BigNum b){
		BigNum c = BigNum.ZERO;
		int i;
		for(i = 0; i < b.lastDigit; i++){
			a.shift(1);
			for(int j = 0; j < b.digits[i]; j++){
				c = add(c,a);
			}
		}
		a.shift(-i);
		return c;
	}
	public static BigNum add(BigNum a, BigNum b){
		int carry = 0;
		BigNum c = new BigNum();
		c.lastDigit = Math.max(a.lastDigit, b.lastDigit) + 1;
		for(int i = 0; i < c.lastDigit ; i++){
			int sum = carry + a.digits[i] + b.digits[i];
			c.digits[i] = sum % 10;
			carry = sum / 10;
		}
		c.zeroJustify();
		return c;
	}
	// the magnitude of the subtraction as sign has not been implemented
	public static BigNum subtract(BigNum a, BigNum b){
		BigNum c = new BigNum();
		if(compare(a,b) < 0){
			c = subtract(b,a);
			return c;
		}
		int borrow = 0;
		c.lastDigit = Math.max(a.lastDigit, b.lastDigit);
		for(int i = 0; i <= (c.lastDigit); i++){
			int s = a.digits[i] - borrow - b.digits[i]; // placeholder
			if(s < 0){
				s += 10;
				borrow = 1;
			}else {
				borrow = 0;
			}
			c.digits[i] = s;
		}
		c.zeroJustify();
		return c;
	}
	// equivalent to a * 10 ^ d
	public void shift(int d){
		if(d < 0){
			for(int i = 0; i <= lastDigit+d; i++){
				digits[i] = digits[i - d];
				digits[i - d] = 0;
			}
		}else {
			if(lastDigit == 0 && digits[0] == 0)return;
			
			for(int i = lastDigit; i >= 0; i--){
				digits[i + d] = digits[i];
				digits[i] = 0;
			}
			
		}
		lastDigit += d;
	}
	public static int compare(BigNum a, BigNum b){
		if(a.lastDigit != b.lastDigit)
			return a.lastDigit - b.lastDigit;
		
		int d = a.lastDigit;
		for(int j = d; j >= 0; j--){
			if(a.digits[j] != b.digits[j])
				return a.digits[j] - b.digits[j];
		}
		return 0;
	}
	private void zeroJustify(){
		while(lastDigit > 0 && digits[lastDigit] == 0)
			lastDigit--;
	}
	
	public String toString(){
		StringBuffer s = new StringBuffer();
		for(int i = lastDigit; i >= 0; i--)
			s.append(digits[i]);
		return s.toString();
	}
}
