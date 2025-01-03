package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bj24499 {

    int n;
    int k;
    List<Integer> A;

    String answer;

    void run() {
        init();
        solve();
        output();
    }

    void init() {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var splitter = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(splitter.nextToken());
            k = Integer.parseInt(splitter.nextToken());
            splitter = new StringTokenizer(reader.readLine());
            A = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                var taste = Integer.parseInt(splitter.nextToken());
                A.add(taste);
            }
        } catch (IOException ignored) {}
    }

    void solve() {
        A.addAll(List.copyOf(A));
        var cumulativeSum = new ArrayList<Integer>();
        cumulativeSum.add(A.get(0));
        for (int i = 1; i < n * 2; i++) {
            var sum = cumulativeSum.get(i - 1) + A.get(i);
            cumulativeSum.add(sum);
        }
        var subs = new ArrayList<Integer>();
        for (int i = 0; i < n * 2 - k; i++) {
            var sub = cumulativeSum.get(i + k) - cumulativeSum.get(i);
            subs.add(sub);
        }
        answer = String.valueOf(Collections.max(subs));
    }

    void output() {
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new Bj24499().run();
    }
}
