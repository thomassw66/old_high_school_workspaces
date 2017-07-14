
public class Binary {

	public static void main(String []a ){
		System.out.printf("%64s\n","0"+Long.toBinaryString(6962645667329216838L));
		System.out.println(Long.toBinaryString(-9213219107527098271L));
		System.out.println(Long.toBinaryString(-8636705539236951775L));
		System.out.printf("%64s\n","0"+Long.toBinaryString(1301971326710323201L));
		String finstr = "0"+Long.toBinaryString(1301971326710323201L)+Long.toBinaryString(-8636705539236951775L)+Long.toBinaryString(-9213219107527098271L)+"0"+Long.toBinaryString(6962645667329216838L);
		System.out.println(finstr);
		finstr = reversed(finstr);
		String f = "";
		for(int i = 0; i < finstr.length()-1; i+=2){
			int x = Integer.parseInt(finstr.substring(i, i +2),2);
			f =  f + x;
		}
		System.out.println(f);
	}
	static String reversed(String s){
		String r = "";
		for(int i = 0; i < s.length(); i++){
			r = s.charAt(i)+r;
		}
		return r;
	}
}
