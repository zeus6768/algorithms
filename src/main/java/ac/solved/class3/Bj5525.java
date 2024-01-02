package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj5525 {

    int n;
    int m;
    String s;

    public static void main(String[] args) {
        new Bj5525().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            s = br.readLine();
        } catch (IOException ignored) {}
    }

    void solve() {
        int answer = 0;
        int pLength = 2 * n + 1;
        boolean wasI = false;
        int length = 0;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (!wasI) {
                    length++;
                } else {
                    answer += getCountOfP(pLength, length);
                    length = 1;
                }
                wasI = true;
            } else {
                if (wasI) {
                    length++;
                } else {
                    answer += getCountOfP(pLength, length);
                    length = 0;
                }
                wasI = false;
            }
        }
        answer += getCountOfP(pLength, length);
        System.out.println(answer);
    }

    int getCountOfP(int pLength, int length) {
        if (length >= pLength) {
            return (length - pLength) / 2 + 1;
        }
        return 0;
    }
}