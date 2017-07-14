import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class PlayboyChimp {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int h = Integer.parseInt(in.readLine());
		String hs =  in.readLine();
		String [] s = hs.split("\\s");
		int [] heights = new int [h];
		for(int i = 0; i < h; i++){
			heights[i] = Integer.parseInt(s[i]);
		}
		int q = Integer.parseInt(in.readLine());
		String que =  in.readLine();
		s = que.split("\\s");
		int [] queries = new int [q];
		for(int i = 0; i < q; i++){
			queries[i] = Integer.parseInt(s[i]);
		}
		
		//System.out.println(Arrays.toString(s));
		for(int i = 0; i < q; i++){
			query(queries[i],heights);
		}
	}
	static void query(int q,int []h){
		int a = bsearch(q, h, 0, h.length-1);
		//System.out.println(a);
		
		String partA = "X";
		String partB = "X";
		//we did not find one with the exact same height
		if(a < 0){
			int b = - a - 1;
			//System.out.println(b);
			
			if(b == 0){
				partB = "" + h[0];
			}else if (b == h.length){
				partA = "" + h[h.length-1];
			}else {
				partA = "" + h[b-1];
				partB = "" + h[b];
			}
		}else{
			int c = a - 1;
			int d = a + 1;
			while(c >= 0){
				if(h[c] != q){
					partA = "" + h[c];
					break;
				}else{
					c--;
				}
			}
			while(d < h.length){
				if(h[d] != q){
					partB = "" + h[d];
					break;
				}else{
					d++;
				}
			}
		}

		System.out.printf("%s %s\n",partA,partB);
	}
	public static int bsearch(int q, int [] a, int first, int last){
		if(first > last)
			return -1 - first;
		
		int mid = (first + last) >> 1;
		int midVal = a[mid];
		
		if(midVal < q)
			return bsearch(q, a, mid+1, last);
		
		else if(midVal > q)
			return bsearch(q, a, first, mid - 1);
		
		else
			return mid;
	}
}
