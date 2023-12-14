package ac.solved.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2630 {

    int n;
    int[][] papers;
    int whiteCount;
    int blueCount;

    public static void main(String[] args) {
        new Bj2630().run();
    }

    void run() {
        init();
        solve(n, 0, 0);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            n = Integer.parseInt(br.readLine());
            papers = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    papers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            whiteCount = 0;
            blueCount = 0;
        } catch (Exception ignored) {}
    }

    void solve(int size, int initialX, int initialY) {
        boolean white = isWhite(size, initialX, initialY);
        boolean blue = isBlue(size, initialX, initialY);
        if (white) {
            whiteCount++;
            return;
        }
        if (blue) {
            blueCount++;
            return;
        }
        int nextSize = size / 2;
        solve(nextSize, initialX, initialY);
        solve(nextSize, initialX, initialY + nextSize);
        solve(nextSize, initialX + nextSize, initialY);
        solve(nextSize, initialX + nextSize, initialY + nextSize);
    }

    boolean isWhite(int size, int initialX, int initialY) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (papers[initialX + i][initialY + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isBlue(int size, int initialX, int initialY) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (papers[initialX + i][initialY + j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
