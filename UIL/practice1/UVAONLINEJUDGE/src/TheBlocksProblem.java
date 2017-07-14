import java.util.Scanner;
import java.util.Stack;


public class TheBlocksProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		int s = in.nextInt();
		initWorld(s);
		String input = in.next();
		while(!input.equals("quit")){
			
			int start = in.nextInt();
			String detail = in.next();
			int end = in.nextInt();
			
			if(input.equals("move")){
				removeTop(searchFor(start),start);
			}
			if(detail.equals("onto")){
				removeTop(searchFor(end),end);
			}
			
			move(start,searchFor(start),searchFor(end));
			input = in.next();
		}
		outPut();
	}
	static Stack<Integer> [] world;
	public static void outPut(){
		for(int i = 0; i < world.length;i++){
			System.out.printf("%d:",i);
			System.out.println(toString(world[i]));
		}
	}
	public static String toString(Stack<Integer> s){
		if(s.size() > 0){
			int x = s.pop();
			String i = toString (s);
			return i + " " + x;
		}
		return "";
	}
	public static void initWorld(int size){
		world = new Stack[size];
		for(int i = 0; i < size; i++){
			world[i] = new Stack<Integer>();
			world[i].push(i);
		}
	}
	public static int searchFor(int a){
		for(int i = 0; i< world.length;i++){
			if(world[i].contains(a))
				return i;
		}
		return -1;
	}
	public static void removeTop(int loc,int a){
		while(world[loc].peek() != a){
			int x = world[loc].pop();
			world[x].push(x);
		}
	}
	public static void move(int a, int start, int dest){
		int x = world[start].pop();
		if(x != a){
			move(a,start,dest);
		}
		world[dest].push(x);
	}
}
