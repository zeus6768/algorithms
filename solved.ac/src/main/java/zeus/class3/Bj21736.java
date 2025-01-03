package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj21736 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    static final int[][] DXY = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    String[] campus;

    List<Integer> start;
    Queue<List<Integer>> queue;
    boolean[][] visited;

    int n;
    int m;

    int answer;

    public static void main(String[] args) {
        Bj21736 main = new Bj21736();
        main.init();
        main.findFriends();
        main.printAnswer();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        queue = new LinkedList<>();
        visited = new boolean[n][m];
        answer = 0;
        initCampus();
    }

    void initCampus() {
        campus = new String[n];
        for (int i = 0; i < n; i++) {
            campus[i] = input();
            for (int j = 0; j < m; j++) {
                initStart(i, j);
            }
        }
    }

    void initStart(int x, int y) {
        if (isStart(x, y)) {
            start = List.of(x, y);
            queue.add(start);
        }
    }

    void findFriends() {
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            addIfFriend(now);
            find(now);
        }
    }

    void addIfFriend(List<Integer> now) {
        int x = now.get(0);
        int y = now.get(1);
        if (isFriend(x, y)) {
            answer++;
        }
    }

    void find(List<Integer> now) {
        for (int[] dxy : DXY) {
            int nx = now.get(0) + dxy[0];
            int ny = now.get(1) + dxy[1];
            if (canGo(nx, ny)) {
                queue.add(List.of(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    boolean canGo(int x, int y) {
        return isInRange(x, y) && !visited[x][y] && !isWall(x, y);
    }

    boolean isInRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    boolean isStart(int x, int y) {
        return campus[x].charAt(y) == 'I';
    }

    boolean isFriend(int x, int y) {
        return campus[x].charAt(y) == 'P';
    }

    boolean isWall(int x, int y) {
        return campus[x].charAt(y) == 'X';
    }

    void printAnswer() {
        if (answer == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(answer);
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
