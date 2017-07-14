import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class BalancingBank {
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		int travelers = in.nextInt();
		int transactions = in.nextInt(); in.nextLine();
		int cases = 0;
		while(!(travelers == 0 && transactions == 0)){
			HashMap<String, Person> people = new HashMap<String, Person>();
			for(int i = 0; i < travelers; i ++){
				String name = in.nextLine();
				people.put(name, new Person(name));
			}
			for(int i = 0; i < transactions; i++){
				String giver = in.next();
				String reciever = in.next();
				int amount = in.nextInt(); in.nextLine();
				people.get(giver).lent(amount);
				people.get(reciever).borrow(amount);
			}
			ArrayList<Person> c = new ArrayList<Person>(people.values());
			Collections.sort(c);
			System.out.println("Case #"+(++cases));
			balance(c);
			System.out.println();
			travelers = in.nextInt();
			transactions = in.nextInt(); in.nextLine();
		}
	}
	//sorted list
	static void balance(List <Person> p){
		int i = 0, j = p.size() - 1;
		while(i < j){
			Person mooch = p.get(i);
			Person collector = p.get(j);
			
			System.out.printf("%s %s ", mooch.name, collector.name);
			int transaction;
			if(mooch.owed + collector.owed == 0){
				transaction = collector.owed;
				j--;
				i++;
			}else {
				if(Math.abs(mooch.owed) > Math.abs(collector.owed)){
					transaction = collector.owed;
					j--;
				}else{
					transaction = Math.abs(mooch.owed);
					i++;
				}
			}
			mooch.lent(transaction);
			collector.borrow(transaction);
			System.out.printf("%d\n", transaction);
		}
	}
}
class Person implements Comparable<Person>{
	String name;
	int owed = 0;
	public Person(String n){
		name = n;
	}
	void lent(int n){
		owed += n;
	}
	void borrow(int n){
		owed -= n;
	}
	public int compareTo(Person p){
		return this.owed - p.owed;
	}
	public String toString(){
		return name + ": " + owed;
	}
}
