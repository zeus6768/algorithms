package ac.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bj11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();
        int answer = 0;
        for (char c : numbers) answer += c;
        answer -= N*48;
        System.out.println(answer);
    }
}