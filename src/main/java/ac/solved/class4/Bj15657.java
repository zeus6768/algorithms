package ac.solved.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj15657 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;
    int m;

    List<Integer> numbers;

    Stack<Integer> stack;

    StringBuilder answer;

    public static void main(String[] args) {
        Bj15657 main = new Bj15657();
        main.init();
        main.solve(0);
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

    void solve(int index) {
        if (stack.size() == m) {
            append();
            return;
        }
        for (int i = index; i < numbers.size(); i++) {
            stack.add(numbers.get(i));
            solve(i);
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
