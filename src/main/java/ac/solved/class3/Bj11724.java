package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj11724 {

    int n;
    int m;
    List<List<Integer>> graph;

    boolean[] visited;

    public static void main(String[] args) {
        new Bj11724().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            visited = new boolean[n+1];
        } catch (IOException ignored) {}
    }

    void solve() {
        int count = 0;
        for (int node = 1; node <= n; node++) {
            if (!visited[node]) {
                count++;
                dfs(node);
            }
        }
        System.out.println(count);
    }

    void dfs(int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
