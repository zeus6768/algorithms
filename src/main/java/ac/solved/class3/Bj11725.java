package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj11725 {

    BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    List<List<Integer>> nodes;

    boolean[] visited;
    int[] parentNodes;

    int n;

    StringBuilder answer;

    public static void main(String[] args) {
        Bj11725 main = new Bj11725();
        main.init();
        main.solve();
    }

    void init() {
        n = Integer.parseInt(input());
        nodes = new ArrayList<>();
        visited = new boolean[n+1];
        parentNodes = new int[n+1];
        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            int node1 = Integer.parseInt(tokenizer.nextToken());
            int node2 = Integer.parseInt(tokenizer.nextToken());
            nodes.get(node1).add(node2);
            nodes.get(node2).add(node1);
        }
        answer = new StringBuilder();
    }

    void solve() {
        dfs(1);
        for (int i = 2; i <= n; i++) {
            answer.append(parentNodes[i]).append('\n');
        }
        System.out.print(answer);
    }

    void dfs(int parent) {
        visited[parent] = true;
        for (int child : nodes.get(parent)) {
            if (!visited[child]) {
                parentNodes[child] = parent;
                dfs(child);
            }
        }
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
