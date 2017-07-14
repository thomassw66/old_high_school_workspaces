import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CommonPerm {

	public static void main(String [] args){
		Scanner in = new Scanner (System.in);
		while(in.hasNext()){
			String a = in.nextLine();
			String b = in.nextLine();
			System.out.println(commonPerm(a,b));
		}
	}
	static String commonPerm(String a, String b){
		ArrayList<Character> alist = new ArrayList(),blist = new ArrayList(),common = new ArrayList();
		for(char c : a.toCharArray())
			alist.add(c);
		for(char c : b.toCharArray())
			blist.add(c);
		
		outer:
			for(int i = 0 ;i < alist.size(); ){
				for(int j = 0; j < blist.size(); ){
					if(alist.get(i) == blist.get(j)){
						common.add(alist.get(i));
						alist.remove(i);
						blist.remove(j);
						continue outer;
					}
					j++;
				}
				i++;
			}
		Collections.sort(common);
		//System.out.println(common);
		StringBuilder s = new StringBuilder(common.size());
		for(Character c : common){
			s.append(c);
		}
		return s.toString();
	}
}
