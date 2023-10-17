package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bj1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (i % 125 == 0) answer += 3;
            else if (i % 25 == 0) answer += 2;
            else if (i % 5 == 0) answer++;
        }
        System.out.println(answer);
    }
}
