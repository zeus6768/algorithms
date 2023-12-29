package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7662 {

    enum PriorityType {
        MAX, MIN;

        static PriorityType findByValue(int value) {
            if (value == 1) {
                return MAX;
            }
            if (value == -1) {
                return MIN;
            }
            throw new IllegalArgumentException();
        }
    }

    static class DoublePriorityQueue {

        Map<Integer, Integer> counts = new HashMap<>();

        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> minQueue = new PriorityQueue<>();

        void insert(int value) {
            maxQueue.add(value);
            minQueue.add(value);
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        void delete(PriorityType priorityType) {
            clean();
            Integer value = null;
            if (priorityType == PriorityType.MAX) {
                value = maxQueue.poll();
            }
            if (priorityType == PriorityType.MIN) {
                value = minQueue.poll();
            }
            counts.computeIfPresent(value, (k, v) -> v - 1);
        }

        void clean() {
            while (isHeadRemovable(maxQueue)) {
                maxQueue.poll();
            }
            while (isHeadRemovable(minQueue)) {
                minQueue.poll();
            }
        }

        boolean isHeadRemovable(Queue<Integer> queue) {
            return !queue.isEmpty() && counts.get(queue.peek()) == 0;
        }

        Integer get(PriorityType priorityType) {
            if (priorityType == PriorityType.MAX) {
                return maxQueue.peek();
            }
            if (priorityType == PriorityType.MIN) {
                return minQueue.peek();
            }
            return null;
        }

        void clear() {
            maxQueue.clear();
            minQueue.clear();
            counts.clear();
        }

        boolean isEmpty() {
            return maxQueue.isEmpty() || minQueue.isEmpty();
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    DoublePriorityQueue queue = new DoublePriorityQueue();

    StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        new Bj7662().solve();
    }

    void solve() {
        int t = Integer.parseInt(input());
        while (t-- > 0) {
            runCase();
        }
        System.out.print(answer);
    }

    void runCase() {
        queue.clear();
        int k = Integer.parseInt(input());
        while (k-- > 0) {
            String command = input();
            StringTokenizer st = new StringTokenizer(command);
            String opcode = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            operate(opcode, value);
            queue.clean();
        }
        output();
    }

    void operate(String opcode, int value) {
        if (opcode.equals("I")) {
            queue.insert(value);
        }
        if (opcode.equals("D")) {
            PriorityType priorityType = PriorityType.findByValue(value);
            queue.delete(priorityType);
        }
    }

    String input() {
        try {
            return br.readLine();
        } catch (IOException ignored) {}
        return null;
    }

    void output() {
        if (queue.isEmpty()) {
            answer.append("EMPTY").append('\n');
            return;
        }
        Integer max = queue.get(PriorityType.MAX);
        Integer min = queue.get(PriorityType.MIN);
        answer.append(max).append(' ').append(min).append('\n');
    }
}
