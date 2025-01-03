package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11659 {

    int n;
    int m;
    int[] numbers;

    int[][] ranges;

    StringBuilder answer;

    public static void main(String[] args) {
        new Bj11659().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            numbers = new int[n];
            ranges = new int[m][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int j = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                ranges[i] = new int[]{j, k};
            }
            answer = new StringBuilder();
        } catch (IOException ignored) {}
    }

    void solve() {
        int[] csum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            csum[i] = csum[i-1] + numbers[i-1];
        }
        for (int[] ij : ranges) {
            int i = ij[0];
            int j = ij[1];
            int sum = csum[j] - csum[i-1];
            answer.append(sum).append('\n');
        }
        System.out.print(answer);
    }
}
