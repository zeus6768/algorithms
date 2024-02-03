package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1149 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;
    int[][] RGB;

    public static void main(String[] args) {
        Bj1149 main = new Bj1149();
        main.init();
        main.solve();
    }

    void init() {
        n = Integer.parseInt(input());
        RGB = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            RGB[i][0] = Integer.parseInt(tokenizer.nextToken());
            RGB[i][1] = Integer.parseInt(tokenizer.nextToken());
            RGB[i][2] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    void solve() {
        for (int i = 1; i < n; i++) {
            RGB[i][0] = Math.min(RGB[i-1][1] + RGB[i][0], RGB[i-1][2] + RGB[i][0]);
            RGB[i][1] = Math.min(RGB[i-1][0] + RGB[i][1], RGB[i-1][2] + RGB[i][1]);
            RGB[i][2] = Math.min(RGB[i-1][0] + RGB[i][2], RGB[i-1][1] + RGB[i][2]);
        }
        System.out.println(min(RGB[n-1]));
    }

    int min(int... numbers) {
        return Math.min(numbers[0], Math.min(numbers[1], numbers[2]));
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
