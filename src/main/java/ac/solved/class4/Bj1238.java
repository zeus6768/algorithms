package ac.solved.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1238 {

    final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    List<List<List<Integer>>> roads;

    Queue<List<Integer>> queue;

    int n;
    int m;
    int x;

    int[][] times;

    int answer;

    public static void main(String[] args) {
        Bj1238 main = new Bj1238();
        main.init();
        main.solve();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        x = Integer.parseInt(tokenizer.nextToken());
        answer = 0;
        queue = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(0)));
        initTimes();
        initRoad();
    }

    void initTimes() {
        times = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }
    }

    void initRoad() {
        roads = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            roads.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            int departure = Integer.parseInt(tokenizer.nextToken());
            int arrival = Integer.parseInt(tokenizer.nextToken());
            int time = Integer.parseInt(tokenizer.nextToken());
            roads.get(departure).add(List.of(time, arrival));
        }
    }

    void solve() {
        for (int i = 1; i <= n; i++) {
            find(i);
        }
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, times[x][i] + times[i][x]);
        }
        System.out.println(answer);
    }

    void find(int departure) {
        times[departure][departure] = 0;
        queue.clear();
        queue.add(List.of(0, departure));
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int time = now.get(0);
            int village = now.get(1);
            if (times[departure][village] != time) continue;
            for (List<Integer> road : roads.get(village)) {
                int nextTime = time + road.get(0);
                int nextVillage = road.get(1);
                if (times[departure][nextVillage] > nextTime) {
                    times[departure][nextVillage] = nextTime;
                    queue.add(List.of(nextTime, nextVillage));
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
