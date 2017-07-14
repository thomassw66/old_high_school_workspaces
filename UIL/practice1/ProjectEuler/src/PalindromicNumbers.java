
public class PalindromicNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 100; i < 1000; i ++){
			for(int j = i; j < 1000; j++){
				int c = i * j;
				boolean b = palindrome(Integer.toString(c));
				if(b)System.out.printf("%3d %3d %10d\n",i,j,c);
			}
		}
		System.out.println(palindrome("yolo"));
	}
	static boolean palindrome(String s){
		String rev = reversed(s);
		return s.equals(rev);
	}
	static String reversed(String s){
		String ret = "";
		for(char c : s.toCharArray()){
			ret = c + ret;
		}
		return ret;
	}
}
