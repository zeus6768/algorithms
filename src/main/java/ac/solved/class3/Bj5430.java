package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class Bj5430 {

    int t;
    String p;
    int n;
    Deque<Integer> x;

    boolean isReversed;
    StringJoiner stringJoiner;
    StringBuilder output;

    public static void main(String[] args) {
        new Bj5430().solve();
    }

    void solve() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            t = Integer.parseInt(br.readLine());
            output = new StringBuilder();
            for (int i = 0; i < t; i++) {
                init(br);
                run();
            }
            System.out.println(output);
        } catch (Exception ignored) {}
    }

    void init(BufferedReader br) throws IOException {
        p = br.readLine();
        n = Integer.parseInt(br.readLine());
        x = inputArray(br);
        isReversed = false;
        stringJoiner = new StringJoiner(",", "[", "]");
    }

    void run() {
        for (char function : p.toCharArray()) {
            if (function == 'R') {
                r();
            }
            if (function == 'D') {
                boolean deleted = d();
                if (!deleted) {
                    return;
                }
            }
        }
        appendResult(stringJoiner);
    }

    Deque<Integer> inputArray(BufferedReader br) throws IOException {
        Deque<Integer> array = new ArrayDeque<>();
        String inputString = br.readLine();
        String[] splitted = inputString
                .replace("[", "")
                .replace("]", "")
                .split(",");
        for (int i = 0; i < n; i++) {
            array.add(Integer.parseInt(splitted[i]));
        }
        return array;
    }

    void r() {
        isReversed = !isReversed;
    }

    boolean d() {
        if (x.isEmpty()) {
            output.append("error").append('\n');
            return false;
        }
        if (isReversed) {
            x.removeLast();
        } else {
            x.removeFirst();
        }
        return true;
    }

    void appendResult(StringJoiner stringJoiner) {
        while (!x.isEmpty()) {
            String valueString;
            if (isReversed) {
                valueString = String.valueOf(x.removeLast());
            } else {
                valueString = String.valueOf(x.removeFirst());
            }
            stringJoiner.add(valueString);
        }
        output.append(stringJoiner).append('\n');
    }
}
