import java.util.Scanner;


public class Minesweeper {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int length;//length
		int  width;//width
		int t = 1; //counter for how many cases
		while((length = input.nextInt())!=0 && (width = input.nextInt()) != 0){
			if(t != 1)
				System.out.println();
			input.nextLine();
			int field [][] = new int[length][width]; // minefield
			//read field
			for(int i = 0; i < length; i++){
				String line = input.nextLine();
				for(int j = 0; j < width; j++){
					field[i][j] = (line.charAt(j) == '*')? -1: 0;
				}
			}
			for(int i = 0; i < length; i++){
				for(int j = 0; j < width; j++){
					if(field [i][j] != -1){
						field[i][j] = getMinesAround(field,i,j);
					}
				}
			}
			System.out.println("Field #"+(t++)+":");
			for(int i = 0; i < length; i++){
				for(int j = 0; j < width; j++){
					if(field [i][j] != -1){
						System.out.print(field[i][j]);
					}else{
						System.out.print('*');
					}
				}
				System.out.println();
			}
		}
	}
	static int [][] dirs = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{1,1},{0,1},{-1,1}};
	static int getMinesAround(int [][] field, int x, int y){
		int sum = 0;
		for(int [] d : dirs){
			if(inField(field, x+d[0],y+d[1]))
				if(field[x+d[0]][y+d[1]] == -1)
					sum++;
		}
		return sum;
	}
	static boolean inField(int [][] field, int x, int y){
		return (x < field.length && x >=0 && y < field[x].length && y >= 0);
	}
}
