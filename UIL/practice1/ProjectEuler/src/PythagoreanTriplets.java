import java.util.HashMap;


public class PythagoreanTriplets {
	static final int NUMS = 10000;
	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		
		long  squares[] = new long[1000000];
		long n = 0;
		for(int i = 1; i < NUMS; i++){
			n += ((i - 1) << 1) + 1;  
			squares[i] = n;
		}
		HashMap<Long,Long> map = new HashMap();
		
		for(int i = 1; i < NUMS; i++){
			for(int j = i + 1; j < NUMS; j++){
				long perim = (squares[j] - squares[i]) +(2 * i * j)+  (squares[i] + squares[j]);
				
				if(map.containsKey(squares[j] - squares[i]) && perim < 1000000){
					//System.out.println("NO!!!");
					break;
				}else{
					map.put((squares[j] - squares[i]), squares[i] + squares[j]);
				}
			}
		}
		System.out.println(map.size());
		System.out.println("done " + (System.currentTimeMillis() - a) + " milliseconds");
	}
}
