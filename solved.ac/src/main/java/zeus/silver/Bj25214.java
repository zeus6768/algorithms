package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj25214 {

    int n;
    List<Integer> A;

    String answer;

    void run() {
        init();
        solve();
        output();
    }

    void init() {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            var splitter = new StringTokenizer(reader.readLine());
            A = new ArrayList<>();
            while (splitter.hasMoreTokens()) {
                int num = Integer.parseInt(splitter.nextToken());
                A.add(num);
            }
        } catch (IOException ignored) {}
    }

    void solve() {

    }

    void output() {

    }

    public static void main(String[] args) {
        new Bj25214().run();
    }
}
