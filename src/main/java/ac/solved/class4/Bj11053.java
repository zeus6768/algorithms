package ac.solved.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11053 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;
    int[] A;

    int[] dp;

    public static void main(String[] args) throws IOException {
        Bj11053 main = new Bj11053();
        main.init();
        main.solve();
    }

    void init() {
        n = Integer.parseInt(input());
        A = new int[n];
        dp = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(input());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
            dp[i] = 1;
        }
    }

    void solve() {
        int answer = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
