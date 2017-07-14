import java.io.PrintStream;
import java.util.Scanner;

public class CrackMe2
{
  public static void main(String[] paramArrayOfString)
  {
    System.out.println("Please enter the password:");
    Scanner localScanner = new Scanner(System.in);
    String str = localScanner.next();
    if (str.length() != 16) {
      System.out.println("Wrong");
      return;
    }
    char[] arrayOfChar = str.toCharArray();
    if (arrayOfChar[0] != 'i') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[1] != 'T') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[2] != '6') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[3] != 'c') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[4] != 'h') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[5] != 'i') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[6] != 'w') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[7] != 'e') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[8] != 'T') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[9] != 'o') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[10] != 'h') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[11] != 'y') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[12] != '4') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[13] != 'o') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[14] != 'o') {
      System.out.println("Wrong");
      return;
    }if (arrayOfChar[15] != 't') {
      System.out.println("Wrong");
      return;
    }
    System.out.print("Correct, your key is: ");
    System.out.println(str);
  }
}