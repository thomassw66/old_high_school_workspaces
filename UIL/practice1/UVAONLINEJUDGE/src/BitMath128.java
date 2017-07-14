
public class BitMath128 {

	public static void main(String[] args) {
		Digit a = new Digit("10");
		Digit b = new Digit("101");
		System.out.println(withoutLeadingZeros(sub(b,a,0).toString()));
	}
	static String withoutLeadingZeros(String s){
		int i = 0;
		for( ; i < s.length(); i ++){
			char c = s.charAt(i);
			if(c != '0')break;
		}
		return s.substring(i);
	}
	public static Digit add(Digit a, Digit b, int carry){
		if(a == null && b == null){
			if(carry != 0)
				return new Digit(""+carry);
			else return null;
		}else{
			Digit n = new Digit();
			int sum = (a != null? a.value: 0) + (b != null? b.value: 0) + carry;
			n.value = sum % 16;
			n.next = add((a != null? a.next: null), (b != null? b.next: null), sum / 16);
			return n;
		}
	}//a - b
	//321
	//123
	//198
	public static Digit sub(Digit a, Digit b, int carry){
		if(a == null && b == null) return null;
		Digit n = new Digit();
		int diff = (a != null? a.value: 0) - (b != null? b.value: 0) + carry;
		System.out.println(diff);
		if(diff < 0){
			n.value = diff + 16;
			n.next = sub((a != null? a.next: null), (b != null? b.next: null), -1);
		}else {
			n.value = diff;
			n.next = sub((a != null? a.next: null), (b != null? b.next: null), 0);
		}
		return n;
	}
}
class Digit{
	int value;
	Digit next;
	public static int toInt(char c){
		if(c <= '9' && c >= '0')
			return c - '0';
		else return c - 'A' + 10;
	}
	public static char toChar(int a){
		if(a <= 9)
			return (char)(a + '0');
		else return (char)((a-10) + 'A');
	}
	public static char nthDigit(String s, int n){
		return s.charAt(s.length() - (n+1));
	}
	public Digit(){}
	public Digit(String s){
		value = toInt(nthDigit(s,0));
		if(s.length() > 1)
			next = new Digit(s.substring(0,s.length()-1));
	}
	public String toString(){
		return (next != null? next.toString(): "")+toChar(value);
	}
}