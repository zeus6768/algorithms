package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj10845 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final Deque<Integer> queue = new ArrayDeque<>();
    static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            run(br.readLine());
        }
        System.out.println(answer);
    }

    static void run(String commands) throws IOException {
        StringTokenizer st = new StringTokenizer(commands);
        String command = st.nextToken();
        int value = 0;
        if (command.equals("push")) {
            queue.offer(Integer.valueOf(st.nextToken()));
        } else {
            if (command.equals("pop")) {
                value = (queue.isEmpty()) ? -1 : queue.pop();
            } else if (command.equals("size")) {
                value = queue.size();
            } else if (command.equals("empty")) {
                value = (queue.isEmpty()) ? 1 : 0;
            } else if (command.equals("front")) {
                value = (queue.isEmpty()) ? -1 : queue.getFirst();
            } else if (command.equals("back")) {
                value = (queue.isEmpty()) ? -1 : queue.getLast();
            }
            answer.append(value).append('\n');
        }
    }
}
