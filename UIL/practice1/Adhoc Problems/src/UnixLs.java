
import java.util.Scanner;


public class UnixLs {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while(in.hasNextLine()){
			
			int files = Integer.parseInt(in.nextLine().trim());
			
			String [] fileNames = new String [files];
			int maxLength = -1;
			
			for(int i = 0; i < files; i++){
				fileNames[i] = in.nextLine();
				if(fileNames[i].length() > maxLength){
					maxLength = fileNames[i].length();
				}
			}
			//because we'll always have at least two spaces
			maxLength = maxLength + 2;
			
			int names_per_row = 60 / maxLength;
			//so we dont divide by zero
			names_per_row = (names_per_row == 0? 1: names_per_row);
			
			int number_of_rows = fileNames.length / names_per_row + ((fileNames.length % names_per_row == 0)? 0: 1);
			
			char[][] output = new char[number_of_rows][60];
			//fill with blank spaces
			for(int i = 0; i < output.length;i ++){
				for(int j = 0; j < output[i].length; j++){
					output[i][j] = ' ';
				}
			}
			//sort files
			sort(fileNames,0, fileNames.length - 1);
			
			//fill output
			int index = 0;
			for(int i = 0; i < 60; i += maxLength){
				for(int j = 0; j < number_of_rows; j++){
					if(index >= fileNames.length)break;
					put(output[j], fileNames[index++], i);
				}
			}
			System.out.println("------------------------------------------------------------");
			for(int i = 0; i < output.length;i++){
				System.out.println(output[i]);
			}
		}
		in.close();
	}
	static void put(char [] a, String s, int col){
		for(int i = 0; i < s.length(); i++){
			a[col + i] = s.charAt(i); 
		}
	}
	public static void sort(String [] s, int begin, int end){
		String pivot = s[(begin + end) / 2];
		int i = begin;
		int j = end;
		while(i <= j){
			while(s[i].compareTo(pivot) < 0)
				i++;
			while(s[j].compareTo(pivot) > 0)
				j--;
			if(i <= j){
				swap(s,i,j);
				i++;
				j--;
			}
		}
		if(begin < i-1){
			sort(s,begin, i-1);
		}
		if(i < end){
			sort(s, i, end);
		}
	}
	public static void swap(String [] s, int a, int b){
		String temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}
}
