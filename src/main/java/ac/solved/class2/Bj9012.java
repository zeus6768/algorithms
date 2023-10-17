package ac.solved.class2;

import java.io.*;
import java.util.Stack;

public class Bj9012 {

    static final String YES = "YES";
    static final String NO = "NO";

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(vps(br.readLine()));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }

    static String vps(String input) {
        stack.clear();
        for (char c : input.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (!stack.empty()) stack.pop();
            else return NO;
        }
        return (stack.empty()) ? YES : NO;
    }
}
