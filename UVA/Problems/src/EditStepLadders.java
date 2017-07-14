import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner; 
  //8 tickets and cabana for hawaian falls
public class EditStepLadders { 
  
    public static void main(String []args) throws IOException 
    {	
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	ArrayList<String> list = new ArrayList<String>(25000);
    	
    	String string;
    	while((string = in.readLine()) != null)
    		list.add(string);
    		
    	long start = System.currentTimeMillis();
    	int max = 0;
    	
    	int [] ladder= new int [list.size()];
    	int count = 0;
    	for(int i = 0;i < list.size(); i++){
    		
    		String toEdit = list.get(i);
    		//System.out.println(toEdit);
    		for(int j = 0; j < toEdit.length(); j++){
    			String s = del(toEdit,j);
				if(s.compareTo(toEdit) <= 0)continue;
    			int index = Collections.binarySearch(list, s);
				if(index >= 0 && index > i){
					//System.out.println("\t"+list.get(index));
					ladder[index] = Math.max(ladder[i]+1, ladder[index]);
					max = Math.max(max, ladder[index]);
				}
    		}
    		for(char c = 'a'; c <= 'z'; c++){
    			for(int j = 0; j < toEdit.length(); j++){
    				if(c == toEdit.charAt(j))continue;
    				String s = replace(toEdit, j, c);
    				if(s.compareTo(toEdit) <= 0)continue;
    				int index = Collections.binarySearch(list, s);
    				if(index >= 0 && index > i){
    					ladder[index] = Math.max(ladder[i]+1, ladder[index]);
    					//System.out.println("\t"+list.get(index));
    					max = Math.max(max, ladder[index]);
    				}
    			}
    			for(int j = 0; j <= toEdit.length() ; j++){
    				String s = add(toEdit,j,c);
    				if(s.compareTo(toEdit) <= 0)continue;
    				int index = Collections.binarySearch(list, s);
    				if(index >= 0 && index > i){
    					ladder[index] = Math.max(ladder[i]+1, ladder[index]);
    					max = Math.max(max, ladder[index]);
    					//System.out.println("\t"+list.get(index));
    				}
    			}
    		}
    	}
    	System.out.println(max+1);
    	//System.out.println(System.currentTimeMillis() - start + " milisenconds");
    }

	static String del(String s, int i){
		return (new StringBuffer(s)).deleteCharAt(i).toString();
	}
	static String replace(String s, int i, char c){
		StringBuffer b = new StringBuffer(s);
		b.setCharAt(i, c);
		return b.toString();		
	}
	static String add(String s, int i, char c){
		return (new StringBuffer(s)).insert(i, c).toString();
	}
	/*
abcdefghijklmnop
cat
dig
dog
fig
fin
fine
fog
log
wine
*/
}