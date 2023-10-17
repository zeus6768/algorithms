package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2609 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Bj2609().solve();
    }

    void solve() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        System.out.println(gcd(x, y));
        System.out.println(lcm(x, y));
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
