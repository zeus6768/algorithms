package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2755 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        final int MAX = 15;

        int[][] dp = new int[MAX][MAX];

        int t = Integer.parseInt(br.readLine());

        int k, n;

        for (int i = 0; i < MAX; i++) dp[0][i] = i;

        for (int i = 1; i < MAX; i++)
            for (int j = 0; j < MAX; j++)
                for (int l = 0; l <= j; l++) dp[i][j] += dp[i - 1][l];

        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            answer.append(dp[k][n]).append('\n');
        }

        System.out.println(answer);
    }
}
