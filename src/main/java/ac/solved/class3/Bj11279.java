package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bj11279 {

    static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        new Bj11279().solve();
    }

    void solve() {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(input());
        while (n-- > 0) {
            int value = Integer.parseInt(input());
            if (value == 0) {
                popAndPrint(queue);
            } else {
                insert(queue, value);
            }
        }
        System.out.print(answer);
    }

    void popAndPrint(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            answer.append(0);
        } else {
            int value = queue.poll();
            answer.append(value);
        }
        answer.append('\n');
    }

    void insert(Queue<Integer> queue, int value) {
        queue.add(value);
    }

    String input() {
        try {
            return reader.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
