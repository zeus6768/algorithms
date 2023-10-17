package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bj1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) sequence[i] = Integer.parseInt(br.readLine());

        int idx = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            output.append('+').append('\n');
            while (!stack.isEmpty() && stack.peek() == sequence[idx]) {
                stack.pop();
                idx++;
                output.append('-').append('\n');
            }
        }

        if (!stack.isEmpty())
            System.out.println("NO");
        else
            System.out.println(output);
    }
}
