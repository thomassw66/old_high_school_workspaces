import java.util.Scanner;


public class C{
	
	public static void main(String[] args) {

		System.out.printf("|site|account|group|displayname\n");
		Scanner in = new Scanner (System.in);
		String school = getNext(in); //schoolname
		int team = 1;//number of teams
		while(!(school).equals("END")){
			String teacher = getNext(in);// I dont think we use this?
			String temp ;
			while(isTeam(temp = getNext(in))){
				String name = temp.substring(0, temp.length()-2);
				String bracket = temp.charAt(temp.length()-1) == 'A' ? "Advanced":"Novice";
				System.out.printf("|1|team%d|%s|%s (%s)\n",team++,bracket,name,school);
			}
			school = temp;
		}
	}
	static boolean isTeam(String s){
		return s.charAt(s.length()-1) == 'A'||s.charAt(s.length()-1) == 'N';
	}
	static String getNext(Scanner in){
		String n = in.nextLine();
		if(n.length() > 0)
			return n;
		else 
			return getNext(in);
	}

}
