import java.io.PrintStream;
import java.util.Scanner;

public class Crackme
{
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("Please enter the password:");
    Scanner localScanner = new Scanner(System.in);
    String str = localScanner.next();
    if (str.equals("eupai1AhNu7aeTho")) {
      System.out.println("Correct");
      System.out.print("Your key is: ");
      System.out.print("n");
      System.out.print("0");
      System.out.print("t");
      System.out.print("h");
      System.out.print("1");
      System.out.print("n");
      System.out.print("g");
      System.out.print("_");
      System.out.print("1");
      System.out.print("s");
      System.out.print("_");
      System.out.print("s");
      System.out.print("a");
      System.out.print("f");
      System.out.print("3");
      System.out.print("\n");
    }
    else {
      System.out.println("Wrong");
    }
  }
}