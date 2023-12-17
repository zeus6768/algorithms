package ac.solved.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bj2667 {

    int n;
    String[] map;

    boolean[][] visited;

    int totalCount = 0;
    List<Integer> counts;

    public static void main(String[] args) {
        new Bj2667().run();
    }

    void run() {
        init();
        solve();
        printAnswer();
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            map = new String[n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine();
            }
            counts = new ArrayList<>();
        } catch(Exception ignored) {}
    }

    void solve() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (map[i].charAt(j) == '1' && !visited[i][j]) {
                    totalCount++;
                    counts.add(bfs(i, j));
                }
        Collections.sort(counts);
    }

    void printAnswer() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(totalCount).append('\n');
        for (int count : counts) {
            stringBuilder.append(count).append('\n');
        }
        System.out.println(stringBuilder);
    }

    int bfs(int startX, int startY) {
        visited[startX][startY] = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(startX, startY));
        int count = 1;
        while (!queue.isEmpty()) {
            count += search(queue);
        }
        return count;
    }

    int search(Queue<List<Integer>> queue) {
        int[][] dxy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<Integer> now = queue.poll();
        int x = now.get(0);
        int y = now.get(1);
        int count = 0;
        for (int[] xy : dxy) {
            int nx = x + xy[0];
            int ny = y + xy[1];
            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                queue.offer(List.of(nx, ny));
                count += 1;
            }
        }
        return count;
    }

    boolean canGo(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n)
                && map[x].charAt(y) == '1'
                && !visited[x][y];
    }
}
