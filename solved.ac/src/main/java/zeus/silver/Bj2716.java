package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2716 {

    int n;

    String[] trees;

    StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        new Bj2716().run();
    }

    void run() {
        input();
        solve();
        print();
    }

    void input() {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(reader.readLine());
            trees = new String[n];
            for (int i = 0; i < n; i++) {
                trees[i] = reader.readLine();
            }
        } catch (IOException ignored) {}
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            solve(i);
        }
    }

    void solve(int iteration) {
        String tree = trees[iteration];
        int depth = 0;
        int max = 0;
        for (char brace : tree.toCharArray()) {
            if (brace == '[') depth++;
            if (brace == ']') depth--;
            max = Math.max(max, depth);
        }
        int monkeyCount = (int) Math.pow(2, max);
        answer.append(monkeyCount)
                .append('\n');
    }

    void print() {
        System.out.print(answer);
    }
}
