package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj16928 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;
    int m;

    int[] counts;

    Map<Integer, Integer> ladders;
    Map<Integer, Integer> snakes;

    public static void main(String[] args) {
        Bj16928 snakesAndLadders = new Bj16928();
        snakesAndLadders.init();
        snakesAndLadders.solve();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        counts = new int[101];
        Arrays.fill(counts, Integer.MAX_VALUE);
        initLadders();
        initSnakes();
    }

    void initLadders() {
        ladders = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            ladders.put(from, to);
        }
    }

    void initSnakes() {
        snakes = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            snakes.put(from, to);
        }
    }

    void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        counts[1] = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int count = counts[now];
            if (now == 100) {
                System.out.println(count);
                break;
            }
            search(queue, now);
        }
    }

    void search(Queue<Integer> queue, int now) {
        for (int i = 1; i <= 6; i++) {
            int next = now + i;
            if (next > 100) {
                return;
            }
            next = moveOnLadderOrSnake(next);
            addNext(queue, now, next);
        }
    }

    int moveOnLadderOrSnake(int next) {
        while (ladders.containsKey(next)) {
            next = ladders.get(next);
        }
        while (snakes.containsKey(next)) {
            next = snakes.get(next);
        }
        return next;
    }

    void addNext(Queue<Integer> queue, int now, int next) {
        int count = counts[now] + 1;
        if (count < counts[next]) {
            counts[next] = count;
            queue.add(next);
        }
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
