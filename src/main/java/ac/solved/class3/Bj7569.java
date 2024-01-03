package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7569 {

    int m;
    int n;
    int h;

    List<List<List<Integer>>> tomatoes;

    Queue<List<Integer>> queue;

    static int answer;

    public static void main(String[] args) {
        Bj7569 tomato = new Bj7569();
        tomato.init();
        tomato.bfs();
        tomato.printResult();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input(br));;
        queue = new LinkedList<>();
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        initTomatoBox();
        initTomatos(br, st);
        answer = 0;
    }

    void initTomatoBox() {
        tomatoes = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            tomatoes.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                tomatoes.get(i).add(new ArrayList<>());
            }
        }
    }

    void initTomatos(BufferedReader br, StringTokenizer st) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(input(br));
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatoes.get(i).get(j).add(tomato);
                    if (tomato == 1) {
                        queue.add(List.of(i, j, k, 0));
                    }
                }
            }
        }
    }

    void bfs() {
        while (!queue.isEmpty()) {
            search(queue.poll());
        }
    }

    void search(List<Integer> node) {
        final int[][] dhxy = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        for (int[] hxy : dhxy) {
            int nh = node.get(0) + hxy[0];
            int nx = node.get(1) + hxy[1];
            int ny = node.get(2) + hxy[2];
            int day = node.get(3);
            if (isInRange(nh, nx, ny) && isNotAged(nh, nx, ny)) {
                tomatoes.get(nh).get(nx).set(ny, 1);
                queue.add(List.of(nh, nx, ny, day + 1));
            }
            answer = Math.max(answer, day);
        }
    }

    boolean isInRange(int height, int x, int y) {
        return 0 <= height && height < h && 0 <= x && x < n && 0 <= y && y < m;
    }

    boolean isNotAged(int h, int x, int y) {
        return tomatoes.get(h).get(x).get(y) == 0;
    }

    void printResult() {
        if (isAllAged()) {
            System.out.println(answer);
            return;
        }
        System.out.println(-1);
    }

    boolean isAllAged() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes.get(i).get(j).get(k) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    String input(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
