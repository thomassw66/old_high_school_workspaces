
public class BFing {
	static char a = 0b11111111111111;
	public static void main(String [] aed){
		String a = encode(encode(encode("decodedecodedecodedecodedecodedecodedecode")));
		String b = decode(decode(decode(a)));
		System.out.println(a + "\n" + b);
		System.out.print("[");
		for(char c : a.toCharArray())System.out.printf("%d ", (int) c);
		System.out.print("]");
	}
	static String encode(String s){
		String ret = "";
		for(int i = 0; i < s.length(); i++){
			ret += encodeChar(s.charAt(i));
		}
		return ret;
	}
	static String encodeChar(char a){
		
		//System.out.printf("%08d\n",Integer.parseInt(Integer.toBinaryString((int) a)));
		char b = 0,c = 0;
		for(int i = 0; i < 4; i++){
			b <<= 1;
			int x = a & 1;
			b += x;
			b <<= 1;
			if(x == 0){
				int lol = (int)(Math.random() * 2);
				b += lol;
			}else{
				b += 1;
			}
			a >>= 1;
		}
		for(int i = 0; i < 4; i++){
			c <<= 1;
			int x = a & 1;
			c += x;
			c <<= 1;
			if(x == 0){
				int lol = (int)(Math.random() * 2);
				c += lol;
			}else{
				c += 1;
			}
			a >>= 1;
		}
		//System.out.printf("%08d %08d\n",Integer.parseInt(Integer.toBinaryString((int) b)),
		//								Integer.parseInt(Integer.toBinaryString((int) c)));
		return  b +"" + c; 
	}
	static String decode(String encoded){
		String ret = "";
		for(int i = 0; i < encoded.length()-1; i += 2){
			char a = encoded.charAt(i);
			char b = encoded.charAt(i+1);
			ret += decodeChar(a,b);
		}
		return ret;	
	}
	static char decodeChar(char a, char b){
		char ret = 0;
		for(int i = 0; i < 4; i++){
			ret <<= 1;
			b >>= 1;
			
			ret += b & 1;
			b >>= 1;
		}
		for(int i = 0; i < 4; i++){
			ret <<= 1;
			a >>= 1;
			
			ret += a & 1;
			a >>= 1;
		}
		return ret;
	}
}
