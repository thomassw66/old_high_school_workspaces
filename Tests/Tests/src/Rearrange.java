public class Rearrange {
    public static void main(String[] ar) {
        int[][] A = null;
        rearr(A);
        System.out.println(A);
    }
    
    public static void rearr(int[][] A) {
        int[][] B = { { 1, 2, 3 }, { 1, 2, 3 } };
        A = B;
    }
}
