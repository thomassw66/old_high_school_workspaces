import java.util.Arrays;
import java.util.Stack;


public class RingGame {

	public static void main(String[] args) {
		RingGame g = new RingGame(3); 
		g.move(2, 0, 2);
		System.out.println(g);
	}
	private Stack<Integer> [] stick;
	public RingGame(int rings){
		stick = new Stack[3];
		for(int i = 0; i < stick.length; i ++){
			stick[i] = new Stack<Integer>();
		}
		for(int i = rings; i > 0; i--){
			stick[0].add(i);
		}
	}
	public String toString(){
		return Arrays.toString(stick);
	}
	public static int intermediate(int from, int dest){
		int a = (from + 1) % 3;
		if(a == dest){
			a += 1;
			a %= 3;
			return a;
		}
		return a;
	}
	public void move(int rings, int from, int dest){
		System.out.println(toString());
		if(rings == 1){
			int value = stick[from].pop();
			stick[dest].push(value);
		}
		else {
			int i = intermediate(from,dest);
			move(rings-1,from,i);
			int value = stick[from].pop();
			stick[dest].push(value);
			move(rings-1,i,dest);
		}
	}
}
