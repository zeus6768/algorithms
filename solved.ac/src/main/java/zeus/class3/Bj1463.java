package zeus.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj1463 {

    int n;
    int[] dp;

    public static void main(String[] args) {
        new Bj1463().solve();
    }

    void solve() {
        init();
        getOperationCount();
        System.out.println(dp[1]);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            dp = new int[n+1];
            dp[n] = 0;
            for (int i = 0; i < n; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
        } catch (Exception ignored) {}
    }

    void getOperationCount() {
        for (int i = n; i > 0; i--) {
            if (i % 3 == 0) {
                dp[i/3] = Math.min(dp[i/3], dp[i] + 1);
            }
            if (i % 2 == 0) {
                dp[i/2] = Math.min(dp[i/2], dp[i] + 1);
            }
            dp[i-1] = Math.min(dp[i-1], dp[i] + 1);
        }
    }
}
