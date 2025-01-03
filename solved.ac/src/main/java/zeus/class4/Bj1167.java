package zeus.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1167 {

    static class VertexDistance {
        int vertex;
        int distance;
        public VertexDistance(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    List<List<VertexDistance>> graph;

    boolean[] visited;
    int[] distances;

    int v;

    public static void main(String[] args) {
        Bj1167 main = new Bj1167();
        main.init();
        main.solve();
    }

    void init() {
        v = Integer.parseInt(input());
        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        initArrays();
        for (int i = 0; i < v; i++) {
            initEdge();
        }
    }

    void initArrays() {
        visited = new boolean[v+1];
        distances = new int[v+1];
    }

    void initEdge() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        int from = Integer.parseInt(tokenizer.nextToken());
        while (tokenizer.hasMoreTokens()) {
            int to = Integer.parseInt(tokenizer.nextToken());
            if (to == -1) {
                break;
            }
            int distance = Integer.parseInt(tokenizer.nextToken());
            graph.get(from).add(new VertexDistance(to, distance));
        }
    }

    void solve() {
        int start = findStart();
        initArrays();
        dfs(start, 0);
        int answer = findMaxDistance();
        System.out.println(answer);
    }

    int findStart() {
        dfs(1, 0);
        return findFarthest();
    }

    void dfs(int parent, int distance) {
        visited[parent] = true;
        distances[parent] = distance;
        List<VertexDistance> children = graph.get(parent);
        if (hasChild(parent)) {
            for (VertexDistance child : children) {
                if (!visited[child.vertex]) {
                    dfs(child.vertex, distance + child.distance);
                }
            }
        }
    }

    boolean hasChild(int parent) {
        for (VertexDistance child : graph.get(parent)) {
            if (!visited[child.vertex]) {
                return true;
            }
        }
        return false;
    }

    int findFarthest() {
        int farthest = 0;
        int max = 0;
        for (int i = 1; i <= v; i++) {
            if (max < distances[i]) {
                max = distances[i];
                farthest = i;
            }
        }
        return farthest;
    }

    int findMaxDistance() {
        int max = 0;
        for (int distance : distances) {
            max = Math.max(max, distance);
        }
        return max;
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
