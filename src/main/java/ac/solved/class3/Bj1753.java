package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1753 {

    BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int v;
    int e;
    int k;

    int[] weights;

    List<List<List<Integer>>> graph;
    Queue<List<Integer>> queue;

    StringBuilder answer;

    public static void main(String[] args) {
        Bj1753 main = new Bj1753();
        main.init();
        main.solve();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        v = Integer.parseInt(tokenizer.nextToken());
        e = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(input());
        initWeights();
        initGraph();
        queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.get(1)));
        answer = new StringBuilder();
    }

    void initWeights() {
        weights = new int[v+1];
        Arrays.fill(weights, Integer.MAX_VALUE);
    }

    void initGraph() {
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            graph.get(u).add(List.of(v, w));
        }
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }

    void solve() {
        dijkstra();
        for (int i = 1; i <= v; i++) {
            appendAnswer(weights[i]);
        }
        System.out.print(answer);
    }

    void dijkstra() {
        initWeights();
        weights[k] = 0;
        queue.offer(List.of(k, 0));
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int node = now.get(0);
            int weight = now.get(1);
            if (weights[node] != weight) continue;
            for (List<Integer> next : graph.get(node)) {
                int nextNode = next.get(0);
                int nextWeight = next.get(1) + weight;
                if (nextWeight < weights[nextNode]) {
                    weights[nextNode] = nextWeight;
                    queue.add(List.of(nextNode, nextWeight));
                }
            }
        }
    }

    void appendAnswer(int to) {
        if (to == Integer.MAX_VALUE) {
            answer.append("INF").append('\n');
            return;
        }
        answer.append(to).append('\n');
    }
}
