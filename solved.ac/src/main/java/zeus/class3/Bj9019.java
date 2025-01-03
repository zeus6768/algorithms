package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.IntFunction;

public class Bj9019 {

    enum Command {

        D(n -> (n * 2) % MAX),
        S(n -> (n == 0) ? 9999 : n - 1),
        L(n -> ((n % 1000) * 10) + (n / 1000)),
        R(n -> (n / 10) + ((n % 10) * 1000));

        final IntFunction<Integer> function;

        Command(IntFunction<Integer> function) {
            this.function = function;
        }

        int apply(int n) {
            return function.apply(n);
        }
    }

    static final int MAX = 10000;

    BufferedReader reader;

    StringBuilder[] commandRecords;
    Queue<Integer> queue;

    StringBuilder answer;

    public static void main(String[] args) {
        Bj9019 dslr = new Bj9019();
        dslr.run();
        System.out.print(dslr.answer);
    }

    void run() {
        init();
        int t = Integer.parseInt(input());
        while(t-- > 0) {
            clear();
            StringTokenizer st = new StringTokenizer(input());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            solve(a, b);
        }
    }

    void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        commandRecords = new StringBuilder[MAX];
        queue = new LinkedList<>();
        answer = new StringBuilder();
    }

    void clear() {
        Arrays.fill(commandRecords, null);
        queue.clear();
    }

    void solve(int a, int b) {
        queue.add(a);
        commandRecords[a] = new StringBuilder();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            appendAnswer(now, b);
            search(now);
        }
    }

    void appendAnswer(int now, int b) {
        if (now == b) {
            StringBuilder commandRecord = commandRecords[now];
            answer.append(commandRecord).append('\n');
        }
    }

    void search(int now) {
        StringBuilder commandRecord = commandRecords[now];
        for (Command command : Command.values()) {
            int result = command.apply(now);
            if (commandRecords[result] == null) {
                queue.add(result);
                commandRecords[result] = new StringBuilder(commandRecord).append(command.name());
            }
        }
    }

    String input() {
        try {
            return reader.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
