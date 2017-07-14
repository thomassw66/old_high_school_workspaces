import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		char [] a = {'a','b','f'};
		boolean b[] = new boolean [a.length];
		generateEveryCombination(0,a,b,"");*/
		System.out.println(32*32);
	}
	public static void genAllCombos(char [] a){
		boolean used[] = new boolean [a.length];
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a.length; j++){
				if(used[j])
					continue;
				
			}
		}
	}
	public static void generateEveryCombination(int index, char [] s,boolean [] used, String sol){
		if(index >= s.length){
			System.out.println(sol);
			return;
		}
		for(int i= 0; i < s.length;i++){
			if(used[i])
				continue;
			used[i] = true;
			String b = sol + s[i];
			generateEveryCombination(index+1,s,used,b);
			used[i] = false;
		}
	}
}