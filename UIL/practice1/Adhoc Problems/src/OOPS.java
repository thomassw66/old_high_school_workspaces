import java.util.Scanner;


public class OOPS {
	public static void main(String[] args) {

		Scanner in = new Scanner (System.in);
		String s = "";
		while(in.hasNext()){
			s += in.next();
		}
		
		System.out.println(parse(s));
	}
	static String parse(String input){
		String source_code = "";
		int addr = 0;
		while(addr < input.length()){
			Instruction inst = getInstruction(input.charAt(addr));
			source_code += inst.name;
			addr ++;
			
			for(int i = 0; i < inst.args ; i++){
				String argument = input.substring(addr, addr+4);
				char first = argument.charAt(0);
				
				//calculate operand
				String dataType = operand(first);
				
				//last to bits of first
				int v = ((first - ((first >= '0' && first <= '9')? '0': ('A'-10)))  % 4) << 12;
				//plus the other 12 bits
				v = v + toInteger(argument.substring(1));
				
				if(dataType.equals("R")){
					v %= 1024;
				}
				
				source_code += ((i  > 0)? "," : " ")+(dataType+v);
				addr += 4;
			}
			source_code+="\n";
		}
		return source_code;
	}
	static int toInteger(String hex){
		char c;
		int fin = 0;
		for(int i = 0; i < hex.length(); i++){
			c = hex.charAt(i);
			fin <<= 4;
			if(c >= '0' && c <= '9')
				fin += (c-'0');
			else if (c >= 'A' && c <= 'F')
				fin += (10 + (c - 'A'));
		}
		return fin;
	}
	static String operand(char operandBits){
		switch(operandBits){
			case '0':
			case '1':
			case '2':
			case '3':
				return "R";
			case '4':
			case '5':
			case '6':
			case '7':
				return "$";
			case '8':
			case '9':
			case 'A':
			case 'B':
				return "PC+";
			case 'C':
			case 'D':
			case 'E':
			case 'F':
				return "";
			default:
				return "";
		}
	}
	static Instruction getInstruction(char c){
		switch(c){
		case '0':
			return new Instruction("ADD", 2);
		case '1':
			return new Instruction("SUB", 2);
		case '2':
			return new Instruction("MUL", 2);
		case '3':
			return new Instruction("DIV", 2);
		case '4':
			return new Instruction("MOV", 2);
		case '5':
			return new Instruction("BREQ", 1);
		case '6':
			return new Instruction("BRLE", 1);
		case '7':
			return new Instruction("BRLS", 1);
		case '8':
			return new Instruction("BRGE", 1);
		case '9':
			return new Instruction("BRGR", 1);
		case 'A':
			return new Instruction("BRNE", 1);
		case 'B':
			return new Instruction("BR", 1);
		case 'C':
			return new Instruction("AND", 3);
		case 'D':
			return new Instruction("OR", 3);
		case 'E':
			return new Instruction("XOR", 3);
		case 'F':
			return new Instruction("NOT", 1);
		default:
		return null;
		}
	}
}
class Instruction{
	int args;
	String name;
	public Instruction(String s, int args){
		name = s;
		this.args = args;
	}
}
