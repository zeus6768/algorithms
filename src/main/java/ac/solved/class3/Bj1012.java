package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1012 {

    static int[][] dxy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int m, n, k;
    static boolean[][] cabbage;
    static boolean[][] visited;

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cabbage = new boolean[n][m];
            visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[y][x] = true;
            }
            int worm = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (cabbage[j][l] && !visited[j][l]) {
                        bfs(l, j);
                        worm++;
                    }
                }
            }
            answer.append(worm).append('\n');
        }
        System.out.println(answer);
    }

    static void bfs(int sx, int sy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sx, sy});
        visited[sy][sx] = true;
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            for (int[] dxdy : dxy) {
                int nx = x + dxdy[0];
                int ny = y + dxdy[1];
                if ((0 <= nx && nx < m) && (0 <= ny && ny < n) && cabbage[ny][nx] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
