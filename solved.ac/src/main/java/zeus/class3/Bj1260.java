package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj1260 {

    static StringBuilder answer = new StringBuilder();

    static int n, m;
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        for (int i = 1; i < n+1; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(v);
        answer.append('\n');
        bfs(v);
        System.out.println(answer);
    }

    static void dfs(int v) {
        visited[v] = true;
        answer.append(v).append(' ');
        for (int i = 0; i < graph.get(v).size(); i++) {
            if (!visited[graph.get(v).get(i)]) {
                dfs(graph.get(v).get(i));
            }
        }
    }

    static void bfs(int v) {
        visited = new boolean[n+1];
        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        answer.append(v).append(' ');
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    answer.append(next).append(' ');
                }
            }
        }
    }
}
