package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj10866 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final Deque<Integer> deque = new ArrayDeque<>();
    static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            run(br.readLine());
        }
        System.out.println(answer);
    }

    static void run(String commands) {
        StringTokenizer st = new StringTokenizer(commands);
        String command = st.nextToken();
        int value = 0;
        if (command.equals("push_front")) {
            deque.addFirst(Integer.valueOf(st.nextToken()));
        } else if (command.equals("push_back")) {
            deque.addLast(Integer.valueOf(st.nextToken()));
        } else {
            if (command.equals("pop_front")) {
                value = (deque.isEmpty()) ? -1 : deque.pollFirst();
            } else if (command.equals("pop_back")) {
                value = (deque.isEmpty()) ? -1 : deque.pollLast();
            } else if (command.equals("size")) {
                value = deque.size();
            } else if (command.equals("empty")) {
                value = (deque.isEmpty()) ? 1 : 0;
            } else if (command.equals("front")) {
                value = (deque.isEmpty()) ? -1 : deque.getFirst();
            } else if (command.equals("back")) {
                value = (deque.isEmpty()) ? -1 : deque.getLast();
            }
            answer.append(value).append('\n');
        }
    }
}
