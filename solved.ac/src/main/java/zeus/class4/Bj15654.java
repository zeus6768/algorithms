package zeus.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj15654 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;
    int m;

    List<Integer> numbers;

    Stack<Integer> stack;

    StringBuilder answer;

    public static void main(String[] args) {
        Bj15654 main = new Bj15654();
        main.init();
        main.solve();
        main.printAnswer();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        numbers = new ArrayList<>();
        tokenizer = new StringTokenizer(input());
        while (tokenizer.hasMoreTokens()) {
            int number = Integer.parseInt(tokenizer.nextToken());
            numbers.add(number);
        }
        Collections.sort(numbers);
        stack = new Stack<>();
        answer = new StringBuilder();
    }

    void solve() {
        if (stack.size() == m) {
            append();
            return;
        }
        for (int number : numbers) {
            if (stack.contains(number)) continue;
            stack.add(number);
            solve();
            stack.pop();
        }
    }

    void append() {
        for (int i : stack) {
            answer.append(i).append(' ');
        }
        answer.replace(answer.length()-1, answer.length(), "\n");
    }

    void printAnswer() {
        System.out.print(answer);
    }


    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
