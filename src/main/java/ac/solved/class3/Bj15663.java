package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj15663 {

    BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    int n;
    int m;

    List<Integer> numbers;

    Stack<Integer> stack;

    Set<List<Integer>> permutations;

    StringBuilder answer;

    public static void main(String[] args) {
        Bj15663 main = new Bj15663();
        main.init();
        main.solve();
    }

    void init() {
        initInput();
        initCollections();
    }

    void initInput() {
        StringTokenizer tokenizer = new StringTokenizer(input());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        numbers = new ArrayList<>();
        tokenizer = new StringTokenizer(input());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(tokenizer.nextToken());
            numbers.add(number);
        }
    }

    void initCollections() {
        Collections.sort(numbers);
        stack = new Stack<>();
        permutations = new LinkedHashSet<>();
        answer = new StringBuilder();
    }

    void solve() {
        search();
        printAnswer();
    }

    void search() {
        if (stack.size() == m) {
            addPermutation();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!stack.contains(i)) {
                stack.add(i);
                search();
                stack.pop();
            }
        }
    }

    void addPermutation() {
        List<Integer> nums = new ArrayList<>();
        for (int index : stack) {
            nums.add(numbers.get(index));
        }
        permutations.add(nums);
    }

    void printAnswer() {
        for (List<Integer> permutation : permutations) {
            appendAnswer(permutation);
        }
        System.out.print(answer);
    }

    void appendAnswer(List<Integer> permutation) {
        for (int number : permutation) {
            answer.append(number).append(' ');
        }
        answer.replace(answer.length()-1, answer.length(), "\n");
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
