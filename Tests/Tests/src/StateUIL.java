import static java.lang.System.out;

import java.util.ArrayList;

public class StateUIL {
    static public void main(String[] args) throws Exception {
        ArrayList<Integer> L = new ArrayList<Integer>();
        if (L instanceof Object) {
            out.println(1);
        }
        if (L instanceof ArrayList<?>) {
            out.println(2);
        }
        if (L instanceof ArrayList) {
            out.println(3);
        }
    }
}