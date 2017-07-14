
public class StringExcersizes {

	static String [] getTextFromInQuotes(String line){
		int numQuotes = 0;
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == '"')
				numQuotes++;
		}
		String [] result = new String[numQuotes/2];
		int index = 0;
		for(int i = 0; i < line.length() && index < result.length;){
			if(line.charAt(i) == '"'){
				i++;
				result[index] = "";
				while(line.charAt(i) != '"'){
					result[index] += line.charAt(i);
					i++;
				}
				index++;
			}
			i++;
		}
		return result;
	}
	String getTextInQuotes(String line){
		String text = "";
		for(int i = 0; i < line.length(); ){
			if(line.charAt(i) == '"'){
				i++;
				while(line.charAt(i) != '"'){
					text += line.charAt(i);
					i++;
				}
			}
			i++;
		}
		return text;
	}
}
