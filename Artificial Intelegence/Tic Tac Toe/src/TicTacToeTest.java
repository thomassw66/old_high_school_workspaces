import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;


public class TicTacToeTest {
	static char [] board = {'X','O','X',
							'_','X','_',
							'O','X','O'};
	public static void main(String [] args) throws IOException{
		//File f = new File("out.txt");
		//f.createNewFile();
		//System.setOut(new PrintStream(f));
		MiniMaxSolution a = new MiniMaxSolution();
		int move = a.move('X', board);
		System.out.printf("%d %d\n",move / 3, move % 3);
	}
}
