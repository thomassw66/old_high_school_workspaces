import java.awt.Toolkit;
import java.util.Scanner;
public class IntevervalTime {

	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.print("GO!!");
		for(int i = 1; i <= n; i ++){

			try {
				Thread.sleep(40000);
				Toolkit.getDefaultToolkit().beep();
			} catch (InterruptedException e) { 
				i--;
				e.printStackTrace();
			}
		}
		while(true){
			Toolkit.getDefaultToolkit().beep();
			Thread.sleep(100);
		}
	}

}
