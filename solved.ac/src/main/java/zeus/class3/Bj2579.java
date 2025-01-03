package zeus.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bj2579 {

    int n;
    int[] scoreToStair;

    int[][] dp;

    public static void main(String[] args) {
        new Bj2579().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            scoreToStair = new int[n+1];
            scoreToStair[0] = 0;
            for (int i = 1; i <= n; i++) {
                scoreToStair[i] = Integer.parseInt(br.readLine());
            }
            dp = new int[2][n+1];
            dp[0][1] = scoreToStair[1];
            dp[1][1] = scoreToStair[1];
        } catch (Exception ignore) {}
    }

    void solve() {
        for (int i = 2; i <= n; i++) {
            dp[0][i] = scoreToStair[i] + dp[1][i-1];
            dp[1][i] = scoreToStair[i] + Math.max(dp[0][i-2], dp[1][i-2]);
        }
        int answer = Math.max(dp[0][n], dp[1][n]);
        System.out.println(answer);
    }
}
