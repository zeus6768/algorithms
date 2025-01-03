package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj6064 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int m, n, x, y;

    StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        new Bj6064().run();
    }

    void run() {
        int t = Integer.parseInt(input());
        while (t-- > 0) {
            init();
            int year = solve();
            answer.append(year).append('\n');
        }
        System.out.print(answer);
    }

    void init() {
        StringTokenizer st = new StringTokenizer(input());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    }

    int solve() {
        int max = lcm(m, n);
        int year = x;
        int ny = x % n == 0 ? n : x % n;
        while (year <= max) {
            if (ny == y) {
                return year;
            }
            ny += m;
            ny = ny % n == 0 ? n : ny % n;
            year += m;
        }
        return -1;
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    int gcd(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a;
            a = b;
            b = tmp % a;
        }
        return a;
    }

    String input() {
        try {
            return br.readLine();
        } catch (IOException ignored) {}
        return null;
    }
}
