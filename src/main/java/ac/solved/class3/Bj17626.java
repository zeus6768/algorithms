package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj17626 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(READER.readLine());
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int root = (int) Math.sqrt(i);
            dp[i] = i;
            for (int j = 1; j <= root; j++) {
                dp[i] = Math.min(dp[i], dp[i - (int) Math.pow(j, 2)] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
