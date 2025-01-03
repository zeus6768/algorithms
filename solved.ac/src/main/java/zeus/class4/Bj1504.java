package zeus.class4;

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
import java.util.stream.IntStream;

public class Bj1504 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    List<List<Node>> graph;
    List<Integer> detours;

    int n, e;
    int a, b, c;
    int v1, v2;

    static class Node {
        int id;
        int distance;

        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Bj1504 main = new Bj1504();
        main.init();
        main.solve();
    }

    void init() {
        initGraph();
        initDetours();
    }

    void initGraph() {
        StringTokenizer tokenizer = new StringTokenizer(readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        graph = new ArrayList<>();
        IntStream.rangeClosed(0, n).forEach((__) -> graph.add(new ArrayList<>()));
        e = Integer.parseInt(tokenizer.nextToken());
        while (e-- > 0) {
            tokenizer = new StringTokenizer(readLine());
            a = Integer.parseInt(tokenizer.nextToken());
            b = Integer.parseInt(tokenizer.nextToken());
            c = Integer.parseInt(tokenizer.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
    }

    void initDetours() {
        StringTokenizer tokenizer = new StringTokenizer(readLine());
        v1 = Integer.parseInt(tokenizer.nextToken());
        v2 = Integer.parseInt(tokenizer.nextToken());
    }

    void solve() {
        long[] fromV1 = dijkstra(v1);
        long[] fromV2 = dijkstra(v2);
        long answer = Math.min(
                fromV1[1] + fromV1[v2] + fromV2[n],
                fromV2[1] + fromV2[v1] + fromV1[n]
        );
        if (answer < 0 ||answer > 200_000_000) {
            answer = -1L;
        }
        System.out.println(answer);
    }

    long[] dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        long[] distances = new long[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        queue.add(new Node(start, 0));
        distances[start] = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.distance != distances[now.id]) continue;
            for (Node next : graph.get(now.id)) {
                int nextDistance = now.distance + next.distance;
                if (nextDistance < distances[next.id]) {
                    distances[next.id] = nextDistance;
                    queue.add(new Node(next.id, nextDistance));
                }
            }
        }
        return distances;
    }

    String readLine() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
