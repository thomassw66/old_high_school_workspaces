public class ShiftTest {
    
    public static void main(String[] asdf) {
        int x = 1;
        for (int i = 0; i < 33; i++) {
            System.out.println(Integer.toBinaryString(x << i));
        }
    }
}
