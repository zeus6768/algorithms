package zeus.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj12851 {

    int n;
    int k;

    String answer;

    interface Move {
        int doMove(int position);
    }

    Move backward = position -> position - 1;
    Move forward = position -> position + 1;
    Move teleport = position -> position * 2;

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
        } catch (IOException ignored) {}
    }

    void solve() {
        if (n == k) {
            answer = String.format("%d%n%d", 0, 1);
            return;
        }

        final var MAX = 100_001;

        var moves = List.of(backward, forward, teleport);
        var times = new int[MAX];
        var ways = new int[MAX];
        var queue = new LinkedList<Integer>();
        queue.add(n);
        times[n] = 1;
        ways[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (var move : moves) {
                int next = move.doMove(current);
                if (0 <= next && next < MAX) {
                    if (times[next] == 0) {
                        queue.add(next);
                        times[next] = times[current] + 1;
                        ways[next] = ways[current];
                        continue;
                    }
                    if (times[next] == times[current] + 1) {
                        ways[next] += ways[current];
                    }
                }
            }
        }
        answer = String.format("%d%n%d", times[k] - 1, ways[k]);
    }

    void output() {
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new Bj12851().run();
    }
}
