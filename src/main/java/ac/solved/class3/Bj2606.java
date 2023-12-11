package ac.solved.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj2606 {

    final int START = 1;

    int n, m;
    List<Set<Integer>> network;
    boolean[] visited;

    int answer = 0;

    public static void main(String[] args) {
        new Bj2606().run();
    }

    void run() {
        init();
        dfs(START);
        System.out.println(answer);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            n = Integer.parseInt(br.readLine());
            network = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                network.add(new HashSet<>());
            }
            visited = new boolean[n+1];

            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int computer1 = Integer.parseInt(st.nextToken());
                int computer2 = Integer.parseInt(st.nextToken());
                network.get(computer1).add(computer2);
                network.get(computer2).add(computer1);
            }

        } catch (Exception ignored) {}
    }

    void dfs(int computer) {
        visited[computer] = true;
        for (int nextComputer : network.get(computer)) {
            if (!visited[nextComputer]) {
                answer++;
                dfs(nextComputer);
            }
        }
    }
}
