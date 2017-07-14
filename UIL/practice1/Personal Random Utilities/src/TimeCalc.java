
public class TimeCalc {

	public static void main(String[] args) {
		Time t = new Time("7:48:0");
		System.out.println(t.after(new Time("3:11:0")));
	}
	
}
class Time{
	int value;
	public Time(String time)
	{
		value = valueFromString(time);
	}
	public Time (int v){
		value = v;
	}
	public Time after(Time passed){
		return new Time(value + passed.value);
	}
	//takes string in format of hh:mm:ss
	int valueFromString(String s){
		int ret = 0;
		
		int beg = 0;
		int end = s.indexOf(':');
		
		ret += 3600 * Integer.parseInt(s.substring(beg,end));
		
		beg = end + 1;
		end = s.indexOf(':',beg);
		
		ret += 60 * Integer.parseInt(s.substring(beg,end));
		
		ret += Integer.parseInt(s.substring(end+1));
		
		return ret;
	}
	public String toString(){
		return String.format("%02d:%02d:%02d",value / 3600, (value % 3600) / 60, value % 60);
	}
}