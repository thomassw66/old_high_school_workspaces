import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class SearchingQuickly {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		ArrayList<String> wti = new ArrayList<String>(50);
		String s;
		while((s = in.nextLine()).compareTo("::") != 0){
			wti.add(s);
		}
		Collections.sort(wti);
		ArrayList<String[]> pages = new ArrayList<String[]>(20000);
		String n;
		int sum = 0;
		while(in.hasNext()){
			n = in.nextLine().toLowerCase();
			String s1[] = n.split(" +");
			pages.add(s1);
			sum += s1.length;
		}
		SearchStruct [] index = new SearchStruct[sum];
		int ind = 0;
		for(int i = 0; i < pages.size(); i++){
			for(int j = 0; j < pages.get(i).length; j++){
				index[ind++] = new SearchStruct(pages.get(i)[j],i,j);
			}
		}
		Arrays.sort(index);
		for(SearchStruct ser : index){
			if(Collections.binarySearch(wti, ser.s) < 0){
				for(int i = 0; i < pages.get(ser.page).length; i++){
					if(i != 0)
						System.out.print(" ");
					if(i == ser.nth_word){
						System.out.print(ser.s.toUpperCase());
					}else {
						System.out.print(pages.get(ser.page)[i]);
					}
				}
				System.out.println();
			}
		}
	}
}
class SearchStruct implements Comparable<SearchStruct>{
	String s;
	int page;
	int nth_word;
	public SearchStruct(String s, int p, int n){
		this.s = s;
		page = p;
		nth_word = n;
	}
	public int compareTo(SearchStruct s) {
		int x = this.s.compareTo(s.s);
		if(x == 0){
			x = this.page - s.page;
			if(x == 0){
				x = this.nth_word - s.nth_word;
			}
		}
		return x;
	}
}