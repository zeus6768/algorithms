package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7576 {

    int m;
    int n;
    int[][] tomatoBox;

    Queue<List<Integer>> queue;

    int answer;

    public static void main(String[] args) {
        new Bj7576().run();
    }

    void run() {
        init();
        solve();
        printResult();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            answer = -1;
            initTomatoBox(br);
        } catch (IOException ignored) {}
    }

    void initTomatoBox(BufferedReader br) throws IOException {
        tomatoBox = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                addTomatoInQueue(i, j);
            }
        }
    }

    void addTomatoInQueue(int i, int j) {
        if (tomatoBox[i][j] == 1) {
            queue.offer(List.of(i, j));
        }
    }

    void solve() {
        while (!queue.isEmpty()) {
            answer++;
            int tomatoCount = queue.size();
            while (tomatoCount-- > 0) {
                List<Integer> now = queue.poll();
                int x = now.get(0);
                int y = now.get(1);
                ripe(x, y);
            }
        }
    }

    void ripe(int x, int y) {
        final int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dxy : dxdy) {
            int nx = x + dxy[0];
            int ny = y + dxy[1];
            if (isUnderAgedTomato(nx, ny)) {
                tomatoBox[nx][ny] = 1;
                queue.offer(List.of(nx, ny));
            }
        }
    }

    boolean isUnderAgedTomato(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m && tomatoBox[x][y] == 0;
    }

    void printResult() {
        if (isAllRiped()) {
            System.out.println(answer);
            return;
        }
        System.out.println(-1);
    }

    boolean isAllRiped() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoBox[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
