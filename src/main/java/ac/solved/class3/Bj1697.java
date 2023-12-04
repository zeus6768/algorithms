package ac.solved.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1697 {

    final int MAX = 100000;
    final int MIN = 0;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n, k;

    public static void main(String[] args) {
        new Bj1697().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        } catch (Exception ignored) {}
    }

    void solve() {
        boolean[] visited = new boolean[MAX+1];
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(n, 0));
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int position = now.get(0);
            int time = now.get(1);
            if (position == k) {
                System.out.println(time);
                return;
            }
            int backwards = position - 1;
            int forward = position + 1;
            int teleport = position * 2;
            if (position > MIN && !visited[backwards]) {
                visited[backwards] = true;
                queue.offer(List.of(backwards, time+1));
            }
            if (position < MAX && !visited[forward]) {
                visited[forward] = true;
                queue.offer(List.of(forward, time+1));
            }
            if (0 <= teleport && teleport <= MAX && !visited[teleport]) {
                visited[teleport] = true;
                queue.offer(List.of(teleport, time+1));
            }
        }
    }
}
