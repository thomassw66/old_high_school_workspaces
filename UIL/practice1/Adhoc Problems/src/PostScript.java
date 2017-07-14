import java.util.Scanner;

public class PostScript {
	static //holds 26 letters then a blank
	char [][][] C5,C1;
	static String fontC5 = ".***..****...****.****..*****.*****..****.*...*.*****...***.*...*.*.....*...*.*...*..***..****...***..****...****.*****.*...*.*...*.*...*.*...*.*...*.*****......."+
						   "*...*.*...*.*...*.*...*.*.....*.....*.....*...*...*......*..*..*..*.....**.**.**..*.*...*.*...*.*...*.*...*.*.....*.*.*.*...*.*...*.*...*..*.*...*.*.....*........"+
						   "*****.****..*.....*...*.***...***...*..**.*****...*......*..***...*.....*.*.*.*.*.*.*...*.****..*...*.****...***....*...*...*..*.*..*.*.*...*.....*.....*........."+
						   "*...*.*...*.*.....*...*.*.....*.....*...*.*...*...*...*..*..*..*..*.....*...*.*..**.*...*.*.....*..**.*..*......*...*...*...*..*.*..**.**..*.*....*....*.........."+
						   "*...*.****...****.****..*****.*......***..*...*.*****..**...*...*.*****.*...*.*...*..***..*......****.*...*.****...***...***....*...*...*.*...*...*...*****.......";
	static String fontC1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		C5 = loadFont(fontC5,5,6);
		C1 = loadFont(fontC1,1,1);
		while(in.hasNext()){
			char[][]output = new char[60][60];
			init(output,'.');
			
			String command = in.next();
			String font = "";
			int row = 0;
			int col = 0;
			String message = "";
			while(!command.equals(".EOP")){
				font = in.next();
				row = in.nextInt() - 1;
				if(command.equals(".P")){
					col = in.nextInt() - 1;
				}
				message = parsed(in.nextLine());
				
				char [][][] myFont = (font.equals("C5")? C5 : C1);
				
				if(command.equals(".C")){
					//center align
					addCenterAligned(output, toPS(message,myFont), row);
				}else if(command.equals(".L")){
					addLeftAligned(output, toPS(message,myFont), row);
				}else if(command.equals(".R")){
					addRightAligned(output, toPS(message,myFont), row);
				}
				else if(command.equals(".P")){
					place(output, toPS(message,myFont), row,0, col,0);
				}
				command = in.next();
			}
			print(output);
			System.out.println();
			System.out.println("------------------------------------------------------------");
			System.out.println();
		}
	}
	static String parsed (String s){
		String r = "";
		int i =0;
		while(i < s.length() && s.charAt(i) != '|'){
			i++;
		}
		i++;
		while(i < s.length() && s.charAt(i) != '|'){
			r+= s.charAt(i);
			i++;
		}
		return r;
	}
	public static void init (char [][] a, char c){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				a[i][j] = c;
			}
		}
	}
	static char [][][] loadFont(String font, int rows, int cols){
					// 26 Letters and a blank
		char r[][][] = new char[27][rows][cols];
		int index = 0;
		
		for(int y = 0; y < r[0].length; y++){	
			for(int x = 0; x < r.length; x++){
				for(int z = 0; z < r[x][y].length; z++){
					r[x][y][z] = font.charAt(index++);
				}
			}
		}
		return r;
	}
	public static char [][] getLetter(char a, char [][][] font){
		if(font == C1){
			char[][]b = {{a}};
			return b;
		}
		if(a <= 'z' && a >= 'a'){
			return font[a - 'a'];
		}
		if(a <= 'Z' && a >= 'A'){
			return font[a - 'A'];
		}
		else{
			return font[26];
		}
	}
	static void print(char [][] a){
		for(char [] b : a){
			System.out.println(b);
		}
	}
	static char [][] toPS(String s, char [][][] font){
		
		char [][] output = new char[font[0].length][s.length() * font[0][0].length];

		
		init (output, '.');
		int index = 0;
		for(int i = 0; i < output[0].length; i += font[0][0].length){
			
			char c = s.charAt(index++);
			place(output, getLetter(c,font),0,0,i,0);
		}
		return output;
	}
	static void addLeftAligned(char [][] output, char [][] a, int row){
		//char [][] a = toPS(s, C5);
		int beginingCol = 0;
		place(output, a, row,0, beginingCol,0);
	}
	static void addRightAligned(char [][] output, char [][] a, int row){
		//char [][] a = toPS(s, C5);
		int beginingCol = output[0].length - a[0].length;
		int bgi = 0;
		if(beginingCol < 0){
			bgi = Math.abs(beginingCol);
			beginingCol = 0;
		}
		place(output, a, row,0, beginingCol,bgi);
	}
	static void addCenterAligned(char [][] output, char [][] a, int row){
		//char [][] a = toPS(s, C5);
		int beginingCol = (output[0].length/2 - a[0].length/2);
		int bgi = 0;
		if(beginingCol < 0){
			bgi = Math.abs(beginingCol);
			beginingCol = 0;
		}
		place(output, a, row,0, beginingCol,bgi);
	}
	static void place(char [][] output, char[][] letters, int begin_output_row, int begin_input_row,int begin_output_col, int begin_input_col){
		for(int i = 0;; i++){
			int ot =  begin_output_row + i;
			int in = begin_input_row + i;
			if(!(ot < output.length && in < letters.length))
				break;
			place(output[ot], letters[in], begin_output_col,begin_input_col);
		}
	}
	static void place(char [] output, char[] letters, int begin_output, int begin_input){
		for(int j = 0; begin_input + j < letters.length && begin_output+j < output.length; j++){
			
			if(letters[begin_input + j] != '.' && letters[begin_input + j] != ' '){
				output[begin_output + j] = letters[begin_input + j]; 
			}
		}
	}
}
