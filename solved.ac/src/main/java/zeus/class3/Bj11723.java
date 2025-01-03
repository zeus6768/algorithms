package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bj11723 {

    BufferedReader br;

    int m;
    Set<Integer> s;

    StringBuilder answer;

    public static void main(String[] args) throws IOException {
        new Bj11723().run();
    }

    void run() throws IOException {
        init();
        solve();
    }

    void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        s = new HashSet<>();
        answer = new StringBuilder();
    }

    void solve() throws IOException {
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            switch (operation) {
                case "add":
                    add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    check(Integer.parseInt(st.nextToken()));
                    break;
                case "toggle":
                    toggle(Integer.parseInt(st.nextToken()));
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
                default:
                    break;
            }
        }
        System.out.print(answer);
    }

    void add(int x) {
        s.add(x);
    }

    void remove(int x) {
        s.remove(x);
    }

    void check(int x) {
        if (s.contains(x)) {
            answer.append(1).append('\n');
            return;
        }
        answer.append(0).append('\n');
    }

    void toggle(int x) {
        if (s.contains(x)) {
            s.remove(x);
            return;
        }
        s.add(x);
    }

    void all() {
        s = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toSet());
    }

    void empty() {
        s.clear();
    }
}
