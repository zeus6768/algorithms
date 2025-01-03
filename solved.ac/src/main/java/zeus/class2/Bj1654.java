package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1654 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int k, n;
    int[] cables;

    public static void main(String[] args) {
        new Bj1654().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            cables = new int[k];
            for (int i = 0; i < k; i++) {
                cables[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException ignored) {}
    }

    void solve() {

        long left = 1;
        long right = Integer.MAX_VALUE;
        long count, mid;

        while (left <= right) {
            count = 0;
            mid = (left+right) / 2;
            for (int i = 0; i < k && count < n; i++) count += cables[i] / mid;
            if (count < n) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(right);
    }
}
