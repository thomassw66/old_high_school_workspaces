
public class StreetNumber {

	public static void main(String[] args) {
		System.out.println(sum(1,34));
	}
	public static int sum(int first, int last){
		int s = first + last;
		int nums = last - first + 1;
		return s * nums / 2;
	}
}
