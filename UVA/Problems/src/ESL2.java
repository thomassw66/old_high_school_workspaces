import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    private List<String> list;
    private int          N;
    private int[]        cost;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.run();
        System.exit(0);
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<String>();
        String strLine = null;
        while ((strLine = br.readLine()) != null && strLine.length() > 0) {
            list.add(strLine);
        }
        // System.out.println("Input read done");
        N = list.size();
        cost = new int[N + 1];
        cost[0] = 1;
        String a;
        int max = 0;
        for (int i = 1; i < N; i++) {
            cost[i] = 1;
            strLine = list.get(i);
            int len = strLine.length();
            for (int flag = 0; flag < 3; flag++) {
                for (int j = 0; j < len; j++) {
                    for (int k = 0; k < 26; k++) {
                        a = trans(strLine, (char) ('a' + k), j, flag);
                        if (strLine.compareTo(a) < 0) {
                            break;
                        }
                        int mid = binarySearch(a, i);
                        if (mid >= 0 && cost[i] < cost[mid] + 1)
                            cost[i] = cost[mid] + 1;
                    }
                }
            }
            for (int k = 0; k < 26; k++) {
                a = trans(strLine, (char) ('a' + k), len, 0);
                if (strLine.compareTo(a) < 0) {
                    break;
                }
                int mid = binarySearch(a, i);
                if (mid >= 0 && cost[i] < cost[mid] + 1)
                    cost[i] = cost[mid] + 1;
            }
            if (cost[i] > max)
                max = cost[i];
        }
        System.out.println(max);
    }

    public String add(String a, char c, int idx) {
        return a.substring(0, idx) + c + a.substring(idx);
    }

    public String del(String a, int idx) {
        return a.substring(0, idx) + a.substring(idx + 1);
    }

    public String chg(String a, char c, int idx) {
        return a.substring(0, idx) + c + a.substring(idx + 1);
    }

    public String trans(String a, char c, int idx, int flag) {
        switch (flag) {
        case 0:
            return add(a, c, idx);
        case 1:
            return del(a, idx);
        default:
            return chg(a, c, idx);
        }
    }

    // The boundary is different.
    public int binarySearch(String s, int end) {
        int left = 0;
        int right = end - 1;
        while (left <= right) {
            int mid = ((left + right) / 2);
            int tmp = s.compareTo(list.get(mid));
            if (tmp == 0)
                return mid;
            else if (tmp < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}