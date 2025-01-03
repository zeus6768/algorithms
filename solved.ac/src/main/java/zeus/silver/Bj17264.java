package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Bj17264 {

    static final String ESCAPE_IRON = "I AM NOT IRONMAN!!";
    static final String STAY_IRON = "I AM IRONMAN!!";

    static final String WIN = "W";
    static final String LOSE = "L";

    int n;
    int p;

    int w;
    int l;
    int g;

    Map<String, String> playerConditions = new HashMap<>();
    List<String> playerNames = new ArrayList<>();

    String answer;

    void run() {
        init();
        solve();
        output();
    }

    void init() {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var splitter = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(splitter.nextToken());
            p = Integer.parseInt(splitter.nextToken());
            splitter = new StringTokenizer(reader.readLine());
            w = Integer.parseInt(splitter.nextToken());
            l = Integer.parseInt(splitter.nextToken());
            g = Integer.parseInt(splitter.nextToken());
            for (int i = 0; i < p; i++) {
                splitter = new StringTokenizer(reader.readLine());
                var name = splitter.nextToken();
                var condition = splitter.nextToken();
                playerConditions.put(name, condition);
            }
            for (int i = 0; i < n; i++) {
                var name = reader.readLine();
                playerNames.add(name);
            }
            answer = STAY_IRON;
        } catch (IOException ignored) {}
    }

    void solve() {
        var score = 0;
        for (var name : playerNames) {
            var condition = playerConditions.get(name);
            if (Objects.nonNull(condition) && condition.equals(WIN)) {
                score += w;
            } else {
                score = Math.max(score - l, 0);
            }
            if (score >= g) {
                answer = ESCAPE_IRON;
                return;
            }
        }
    }

    void output() {
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new Bj17264().run();
    }
}
