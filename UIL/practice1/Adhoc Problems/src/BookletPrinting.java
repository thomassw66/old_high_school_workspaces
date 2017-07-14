import java.util.Scanner;


public class BookletPrinting {


	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int p = Integer.parseInt(in.nextLine());
		while(p > 0){
			System.out.printf("Printing order for %d pages:\n",p);
			print(p);
			p = Integer.parseInt(in.nextLine());
		}
	}
	static void print(int pages){
		int sheets = (pages+3) / 4;
		int left = pages % 4;
		
		int p = 1;
		int e = sheets*4;
		
		for(int i = 1; i <= sheets; i++){
			//if the output wont be entirely blank
			if(p <= pages){
				System.out.printf("Sheet %d, %-5s: %s, %s\n",i,"front",((e <= pages)?e:"Blank"),p);
			}
			p++;e--;
			if(p <= pages){
				System.out.printf("Sheet %d, %-5s: %s, %s\n",i,"back",p,((e <= pages)?e:"Blank"));
			}
			p++;e--;
		}
	}
}
