package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj6064 {

    int t;
    int m;
    int n;
    int x;
    int y;

    StringBuilder answer;

    public static void main(String[] args) throws IOException {
        new Bj6064().run();
    }

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            init(st);
            solve();
        }

        System.out.print(answer);
    }

    void init(StringTokenizer st) {
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    }

    void solve() {
        int year = x;
        int ny = (x % n == 0) ? n : x % n;
        int lcm = lcm(m, n);
        while (year <= lcm) {
            if (ny == y) {
                answer.append(year).append('\n');
                return;
            }
            ny += m;
            ny = (ny % n == 0) ? n : ny % n;
            year += m;
        }
        answer.append(-1).append('\n');
    }

    int gcd(int x, int y) {
        int tmp;
        while (y != 0) {
            tmp = x;
            x = y;
            y = tmp % y;
        }
        return x;
    }

    int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }
}
