package ac.solved.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1931 {

    int n;
    List<List<Integer>> schedules = new ArrayList<>();

    public static void main(String[] args) {
        new Bj1931().run();
    }

    void run() {
        init();
        solve();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try {
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                schedules.add(List.of(start, end));
            }
        } catch (Exception ignored) {}
    }

    void solve() {
        schedules.sort(scheduleComparator());
        List<Integer> prev = schedules.get(0);
        int answer = 1;
        List<Integer> tmp;
        for (int i = 1; i < n; i++) {
            tmp = schedules.get(i);
            if (prev.get(1) <= tmp.get(0)) {
                answer++;
                prev = tmp;
            }
        }
        System.out.println(answer);
    }

    Comparator<List<Integer>> scheduleComparator() {
        return Comparator.comparing((List<Integer> schedule) -> schedule.get(1))
                .thenComparing(schedule -> schedule.get(0));
    }
}
