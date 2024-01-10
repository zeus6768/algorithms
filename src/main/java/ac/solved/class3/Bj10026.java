package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10026 {

    static final int[][] dxdy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int n;
    String[] drawing;

    boolean[][] visited;
    boolean[][] colorBlindVisited;

    public static void main(String[] args) {
        Bj10026 cowArt = new Bj10026();
        cowArt.init();
        cowArt.solve();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            drawing = new String[n];
            for (int i = 0; i < n; i++) {
                drawing[i] = br.readLine();
            }
            visited = new boolean[n][n];
            colorBlindVisited = new boolean[n][n];
        } catch (IOException ignored) {}
    }

    void solve() {
        int count = 0;
        int colorBlindCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char color = drawing[i].charAt(j);
                if (!visited[i][j]) {
                    search(i, j, color);
                    count++;
                }
                if (!colorBlindVisited[i][j]) {
                    colorBlindSearch(i, j, color);
                    colorBlindCount++;
                }
            }
        }
        System.out.printf("%d %d%n", count, colorBlindCount);
    }

    void search(int x, int y, char color) {
        visited[x][y] = true;
        for (int[] dxy : dxdy) {
            int nx = x + dxy[0];
            int ny = y + dxy[1];
            if (canSearch(nx, ny) && isSameColor(nx, ny, color)) {
                search(nx, ny, color);
            }
        }
    }

    void colorBlindSearch(int x, int y, char color) {
        colorBlindVisited[x][y] = true;
        for (int[] dxy : dxdy) {
            int nx = x + dxy[0];
            int ny = y + dxy[1];
            if (canSearchForColorBlind(nx, ny) && isSameColorForBlind(nx, ny, color)) {
                colorBlindSearch(nx, ny, color);
            }
        }
    }

    boolean canSearch(int x, int y) {
        return isInRange(x, y) && !visited[x][y];
    }

    boolean canSearchForColorBlind(int x, int y) {
        return isInRange(x, y) && !colorBlindVisited[x][y];
    }

    boolean isInRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y & y < n;
    }

    boolean isSameColor(int x, int y, char color) {
        return drawing[x].charAt(y) == color;
    }

    boolean isSameColorForBlind(int x, int y, char color) {
        return isBlue(color) == isBlue(drawing[x].charAt(y));
    }

    boolean isBlue(char color) {
        return color == 'B';
    }
}
