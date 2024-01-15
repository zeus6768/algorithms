package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bj11286 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder answer = new StringBuilder();

    Comparator<Integer> absoluteIntegerComparator = (v1, v2) -> {
        if (Math.abs(v1) == Math.abs(v2)) {
            return Integer.compare(v1, v2);
        }
        return Integer.compare(Math.abs(v1), Math.abs(v2));
    };

    public static void main(String[] args) {
        new Bj11286().solve();
    }

    void solve() {
        Queue<Integer> absoluteIntegerHeap = new PriorityQueue<>(absoluteIntegerComparator);
        int n = intInput();
        while (n-- > 0) {
            int value = intInput();
            pop(absoluteIntegerHeap, value);
            add(absoluteIntegerHeap, value);
        }
        System.out.print(answer);
    }

    void pop(Queue<Integer> heap, int value) {
        if (value == 0) {
            if (heap.isEmpty()) {
                answer.append(0);
            } else {
                answer.append(heap.poll());
            }
            answer.append('\n');
        }
    }

    void add(Queue<Integer> heap, int value) {
        if (value != 0) {
            heap.add(value);
        }
    }

    int intInput() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException ignored) {}
        return 0;
    }
}
