package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Bj1764 {

    Set<String> answer;

    Set<String> neverHeard = new HashSet<>();
    Set<String> neverSeen = new HashSet<>();

    int n, m;

    public static void main(String[] args) throws IOException {
        new Bj1764().run();
    }

    void run() {
        init();
        solve();
        printAnswer();
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) neverHeard.add(br.readLine());
            for (int i = 0; i < m; i++) neverSeen.add(br.readLine());
        } catch (Exception ignored) {}
    }

    void solve() {
        neverHeard.retainAll(neverSeen);
        answer = new TreeSet<>(neverHeard);
    }

    void printAnswer() {
        try {
            StringBuilder sb = new StringBuilder();
            for (String name : answer) {
                sb.append(name).append('\n');
            }
            System.out.println(answer.size());
            System.out.println(sb);
        } catch (Exception ignored) {}
    }
}
