package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Bj11403 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;

    int[][] matrix;
    int[][] answer;

    public static void main(String[] args) {
        Bj11403 main = new Bj11403();
        main.init();
        main.solve();
    }

    void init() {
        n = Integer.parseInt(input());
        matrix = new int[n][n];
        answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            StringJoiner stringJoiner = new StringJoiner(" ");
            bfs(i);
            for (int j = 0; j < n; j++) {
                stringJoiner.add(String.valueOf(answer[i][j]));
            }
            System.out.println(stringJoiner);
        }
    }

    void bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 0; i < n; i++) {
                if (matrix[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    answer[start][i] = 1;
                    queue.add(i);
                }
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
