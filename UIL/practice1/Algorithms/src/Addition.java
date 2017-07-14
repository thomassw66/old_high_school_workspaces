
public class Addition {

	public static void main(String[] args) {
		System.out.println(add("1111","1024"));
	}
	static String add(String a, String b){
		if(a.length() < b.length()){
			String twmp = a;
			a = b;
			b = twmp;
		}
		String result = "";
		int A = a.length(),B = b.length();
		int carry = 0;
		int i = 1;
		for(; i <= B ; i++){
			int o = a.charAt(A - i) - '0';
			int p = b.charAt(B - i) - '0';
			int sum = o + p + carry;
			result = (sum % 10) + result;
			carry = sum / 10;
		}
		while(i <= A){
			int o = a.charAt(A - i) - '0';
			int sum = o + carry;
			result = (sum % 10) + result;
			carry = sum / 10;
			i++;
		}
		result = (carry != 0? carry: "") + result;
		return result;
	}
}
