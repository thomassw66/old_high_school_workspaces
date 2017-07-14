
public class LCD {
	
	static int [][] numberBits = {{1,1,1,0,1,1,1},
					{0,0,1,0,0,1,0},
					{1,0,1,1,1,0,1},
					{1,0,1,1,0,1,1},
					{0,1,1,1,0,1,0},
					{1,1,0,1,0,1,1},
					{1,1,0,1,1,1,1},
					{1,0,1,0,0,1,0},
					{1,1,1,1,1,1,1},
					{1,1,1,1,0,1,1}};
	public static void main(String [] args){
		int [] a = {1,7,7,6};
		System.out.println(toAscii(a,2));
	}
	public static String toAscii(int [] nums, int size){
		String finalString = "";
		//top 
		for(int number : nums){
			finalString += " ";
			for(int i = 0; i < size; i++)
				finalString += (numberBits[number][0] == 1)? "-" : " ";
			finalString += " ";
			finalString += " ";
		}
		finalString += "\n";
		//second
		for(int i = 0; i < size; i++){
			for(int number : nums){
				finalString += (numberBits[number][1] == 1)? "|" : " ";
				
				for(int j = 0; j < size; j++)
					finalString += " ";

				finalString += (numberBits[number][2] == 1)? "|" : " ";
				
				finalString += " ";
			}
			finalString += "\n";
		}
		//mid 
		for(int number : nums){
			finalString += " ";
			for(int i = 0; i < size; i++)
				finalString += (numberBits[number][3] == 1)? "-" : " ";
			finalString += " ";
			finalString += " ";
		}
		finalString += "\n";
		//second to last
		for(int i = 0; i < size; i++){
			for(int number : nums){
				finalString += (numberBits[number][4] == 1)? "|" : " ";
				
				for(int j = 0; j < size; j++)
					finalString += " ";

				finalString += (numberBits[number][5] == 1)? "|" : " ";
				
				finalString += " ";
			}
			finalString += "\n";
		}
		//bottom
		for(int number : nums){
			finalString += " ";
			for(int i = 0; i < size; i++)
				finalString += (numberBits[number][6] == 1)? "-" : " ";
			finalString += " ";
			finalString += " ";
		}
		finalString += "\n";
		
		return finalString;
	}
}
