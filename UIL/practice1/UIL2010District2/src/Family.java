import java.util.Scanner;


public class Family {

	static char [][] portrait = new char [18][];
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int n = Integer.parseInt(in.nextLine());
		for(int i = 0; i < n; i++){
			for(int j = 0; j < 18; j++){
				portrait[j] = in.nextLine().toCharArray();
			}
			for(int x = 0; x < 12; x++){
				for(int y = 0 ; y < 18; y++){
					System.out.print(portrait[y][x]);
				}
				System.out.println();
			}
		}
	}
}
/*
1
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
123456789101
*/