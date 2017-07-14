public class Equals {
    
    public static void main(String[] args) {
        System.out.println(new H(0).equals(new H(0)));
    }
}

class H {
    int i;
    
    public H(int i) {
        this.i = i;
    }
}