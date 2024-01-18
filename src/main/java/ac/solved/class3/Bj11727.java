package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int a = 1;
        if (n == 1) {
            return a;
        }
        int b = 3;
        if (n == 2) {
            return b;
        }
        int tmp;
        for (int i = 2; i < n; i++) {
            tmp = a;
            a = b;
            b = (tmp * 2 + b) % 10_007;
        }
        return b;
    }
}
