package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj14940 {

    int n;
    int m;
    int[][] graph;

    public static void main(String[] args) {
        new Bj14940().run();
    }

    void run() {
        init();
        solve();
        printDistances();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    graph[i][j] = -Integer.parseInt(st.nextToken());
                }
            }
        } catch (IOException ignored) {}
    }

    void solve() {
        List<Integer> target = findTarget();
        int x = target.get(0);
        int y = target.get(1);
        bfs(x, y);
    }

    void printDistances() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output.append(graph[i][j]).append(' ');
            }
            output.append('\n');
        }
        System.out.print(output);
    }

    List<Integer> findTarget() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == -2) {
                    return List.of(i, j);
                }
            }
        }
        return List.of();
    }

    void bfs(int x, int y) {
        graph[x][y] = 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(x, y, 0));
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            search(now, queue);
        }
    }

    void search(List<Integer> now, Queue<List<Integer>> queue) {
        int x = now.get(0);
        int y = now.get(1);
        int distance = now.get(2);
        int[][] dxy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] xy : dxy) {
            int nx = x + xy[0];
            int ny = y + xy[1];
            if (canGo(nx, ny)) {
                graph[nx][ny] = distance + 1;
                queue.offer(List.of(nx, ny, graph[nx][ny]));
            }
        }
    }

    boolean canGo(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && graph[x][y] == -1 ;
    }
}
