import javax.script.*;

public class Calc {
	
	public static void main(String [] args) throws ScriptException{
		ScriptEngineManager man = new ScriptEngineManager();
		ScriptEngine js = man.getEngineByName("js");
		System.out.println(js.eval("2*10"));
	}
}
