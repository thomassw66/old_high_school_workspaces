import java.io.File;
import java.util.Scanner;


public class Weak {
	public static void main(String [] welcome) throws Exception{
		Scanner input = new Scanner (new File("weak.dat"));
		int passwords = input.nextInt(); input.nextLine();
		for(int i = 0; i < passwords; i ++){
			String password = input.nextLine().toLowerCase();
			if(isWeak(password)){
				System.out.println("WEAK");
			}else {
				System.out.println("VALID");
			}
		}
	}

	private static boolean isWeak(String password) {
		if(password.length() < 8){
			//System.out.println("not Long engough" + password.length());
			return true;
		}
		boolean hasVowel = false;
		boolean hasDigit = false ;
		boolean hasCons = false;
		
		int repVow = 0;
		
		for(int i = 0; i < password.length(); i ++){
			char c = password.charAt(i);
			
			if(c == 'a' || c == 'e'||c == 'i'||c == 'o'||c == 'u'){
					hasVowel = true;
					repVow ++;
					if(repVow >= 3){
						return true;
					}
			}else if(Character.isDigit(c)){
				hasDigit = true;
				repVow = 0;
			}else if(Character.isAlphabetic(c)){
				hasCons = true;
				repVow = 0;
			}
			
		}
		//System.out.println(hasCons + " " + hasVowel + " " + hasDigit);
		return !(hasCons && hasVowel && hasDigit);
	}
}
