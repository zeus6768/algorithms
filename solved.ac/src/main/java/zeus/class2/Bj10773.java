package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) stack.pop();
            else stack.push(n);
        }
        for (int i : stack) answer += i;
        System.out.println(answer);
    }
}
