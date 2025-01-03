package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj10828 {

    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static Stack<Integer> stack = new Stack<>();
    final static StringBuilder answer = new StringBuilder();

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
        if (command.equals("push")) {
            stack.push(Integer.valueOf(st.nextToken()));
        } else if (command.equals("pop")) {
            if (stack.empty()) {
                answer.append(-1).append('\n');
            } else {
                answer.append(stack.pop()).append('\n');
            }
        } else if (command.equals("size")) {
            answer.append(stack.size()).append('\n');
        } else if (command.equals("empty")) {
            if (stack.empty()) {
                answer.append(1).append('\n');
            } else {
                answer.append(0).append('\n');
            }
        } else if (command.equals("top")) {
            if (stack.empty()) {
                answer.append(-1).append('\n');
            } else {
                answer.append(stack.peek()).append('\n');
            }
        }
    }
}
