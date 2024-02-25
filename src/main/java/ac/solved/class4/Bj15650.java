package ac.solved.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj15650 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;
    int m;

    Stack<Integer> numbers;

    StringBuilder answer;

    public static void main(String[] args) {
        Bj15650 main = new Bj15650();
        main.init();
        main.solve(1);
        main.printAnswer();
    }

    void init() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        numbers = new Stack<>();
        answer = new StringBuilder();
    }

    void solve(int start) {
        if (numbers.size() == m) {
            append(numbers);
            return;
        }
        for (int i = start; i <= n; i++) {
            numbers.add(i);
            solve(i+1);
            numbers.pop();
        }
    }

    void append(List<Integer> numbers) {
        for (int j : numbers) {
            answer.append(j).append(' ');
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
