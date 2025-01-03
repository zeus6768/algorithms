package zeus.class2;

import java.io.*;
import java.util.Stack;

public class Bj4949 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string;

        while (true) {
            string = br.readLine();
            if (string.equals(".")) break;
            bw.write(solve(string));
            bw.flush();
        }

        bw.close();
    }

    static String solve(String input) {
        final String NO = "no\n";
        final String YES = "yes\n";
        Stack<Character> brackets = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[') brackets.add(c);
            else if (c == ')') {
                if (!brackets.empty() && brackets.peek() == '(') brackets.pop();
                else return NO;
            }
            else if (c == ']') {
                if (!brackets.empty() && brackets.peek() == '[') brackets.pop();
                else return NO;
            }
        }
        return (brackets.empty()) ? YES : NO;
    }
}
