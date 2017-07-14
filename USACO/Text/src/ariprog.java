import java.util.Arrays;


public class ariprog {

	public static void main(String [] args){
		int [] bs = bisquares(7);
		Arrays.sort(bs);
		System.out.println(Arrays.toString(bs));
	}
	static int [] bisquares(int N){
		int [] ret = new int [(N+1)*(N+1)];
		int c= 0;
		for(int i = 0; i <= N; i++){
			for(int j = 0; j <= N; j++){
				ret[c++] = i*i + j*j;
			}
		}
		return ret;
	}
}
