package ac.solved.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj1389 {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer;

    int n, m;
    List<Set<Integer>> graph;

    public static void main(String[] args) {
        new Bj1389().solve();
    }

    void solve() {
        init();
        System.out.println(getAnswer());
    }

    void init() {
        input();
        n = getIntToken();
        m = getIntToken();
        initGraph();
    }

    int getAnswer() {
        int answer = 0;
        int minKevinBacon = Integer.MAX_VALUE;
        for (int user = 1; user <= n; user++) {
            int kevinBacon = getKevinBaconFrom(user);
            if (minKevinBacon > kevinBacon) {
                minKevinBacon = kevinBacon;
                answer = user;
            }
        }
        return answer;
    }

    void initGraph() {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            input();
            int friendA = getIntToken();
            int friendB = getIntToken();
            addRelationship(friendA, friendB);
        }
    }

    void addRelationship(int friend1, int friend2) {
        graph.get(friend1).add(friend2);
        graph.get(friend2).add(friend1);
    }

    int getKevinBaconFrom(int start) {
        int kevinBacon = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(start, 0));
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int user = now.get(0);
            int step = now.get(1);
            kevinBacon += step;
            for (int nextUser : graph.get(user)) {
                if (!visited[nextUser]) {
                    visited[nextUser] = true;
                    queue.offer(List.of(nextUser, step+1));
                }
            }
        }
        return kevinBacon;
    }

    void input() {
        try {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
        } catch (Exception ignored) {}
    }

    int getIntToken() {
        return Integer.parseInt(tokenizer.nextToken());
    }
}
