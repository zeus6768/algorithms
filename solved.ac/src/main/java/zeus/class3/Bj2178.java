package zeus.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2178 {

    int n, m;
    String[] maze;

    int[] target;
    int answer;

    public static void main(String[] args) {
        new Bj2178().run();
    }

    void run() {
        init();
        bfs();
        System.out.println(answer);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maze = new String[n];
            for (int i = 0; i < n; i++) {
                maze[i] = br.readLine();
            }
            target = new int[]{n - 1, m - 1};
        } catch (Exception ignored) {}
    }

    void bfs() {
        int[][] drc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0, 0, 1));
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int r = now.get(0);
            int c = now.get(1);
            int d = now.get(2);
            if (isArrived(r, c)) {
                answer = d;
            }
            for (int[] rc : drc) {
                int nr = r + rc[0];
                int nc = c + rc[1];
                if (inBound(nr, nc) && !visited[nr][nc] && canGo(nr, nc)) {
                    visited[nr][nc] = true;
                    queue.offer(List.of(nr, nc, d+1));
                }
            }
        }
    }

    boolean isArrived(int r, int c) {
        return r == target[0] && c == target[1];
    }

    boolean inBound(int r, int c) {
        return (0 <= r && r < n) && (0 <= c && c < m);
    }

    boolean canGo(int r, int c) {
        return maze[r].charAt(c) == '1';
    }
}
