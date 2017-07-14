/*
ID: thomass1
LANG: JAVA
TASK: beads
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class beads {

	public static void main(String [] argss) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new FileWriter("beads.out"));
		
		int N = Integer.parseInt(in.readLine());
		String b = in.readLine();
		
		out.println(answer(b));
		
		out.close();
		System.exit(0);
	}
	public static int longest(MyList list){
		Node i = list.lastNode;
		int max = 0;
		do {
			max = Math.max(twoChanges(i), max);
			i = i.next;
		}while( i != list.lastNode);
		return max;
	}
	public static int twoChanges(Node n){
		Node b = n;
		int s = 0;
		while(n.data == 'w'){
			s++;
			n = n.next;
			if(n == b)return s;
		}
		char c = n.data;
		while(n.data == c || n.data == 'w'){
			s++;
			n = n.next;
			if(n == b)return s;
		}
		while(n.data != c){
			s++;
			n = n.next;
			if(n == b)return s;
		}
		return s;
	}
	static int answer(String beads){
		MyList list = new MyList();
		for (int i = 0; i < beads.length(); i++){
			list.add(beads.charAt(i));
		}
		return longest(list);
	}

}

class Node{
	char data;
	boolean used;
	Node next;
	Node prev;
	public Node(char c){
		data = c;
		next = this;
		prev = this;
		used = false;
	}
}
class MyList {
	Node lastNode;
	public void setFalse(){
		for(Node n = lastNode.next;n != lastNode; n = n.next){
			n.used = false;
		}
		lastNode.used = false;
	}
	public void add(char data){
		Node toAdd = new Node (data);
		if(lastNode == null)
			lastNode = toAdd;
		else {
			toAdd.next = lastNode.next;
			toAdd.prev = lastNode;
			lastNode.next = toAdd;
			lastNode = toAdd;
		}
	}
	public String toString(){
		Node first = lastNode.next;
		String s = "";
		s += first.data;
		Node n = first.next;
		while(n != first){
			s += n.data;
			n = n.next;
		}
		return s;
	}
}