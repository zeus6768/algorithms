package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj11399 {

    int n;
    int[] p;

    public static void main(String[] args) {
        Bj11399 atm = new Bj11399();
        atm.init();
        atm.solve();
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            p = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException ignored) {}
    }

    void solve() {
        Arrays.sort(p);
        int[] cumulativeSum = new int[n];
        cumulativeSum[0] = p[0];
        for (int i = 1; i < n; i++) {
            cumulativeSum[i] = cumulativeSum[i-1] + p[i];
        }
        System.out.println(sum(cumulativeSum));
    }

    int sum(int[] array) {
        int result = 0;
        for (int j : array) {
            result += j;
        }
        return result;
    }
}
