package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9095 {

    BufferedReader br;

    int t;
    int n;

    int[] numbers;

    int count;
    StringBuilder answer;

    public static void main(String[] args) {
        new Bj9095().run();
    }

    void run() {
        try {
            init();
            solve();
        } catch (IOException ignored) {}
        System.out.println(answer);
    }

    void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        numbers = new int[]{1, 2, 3};
        answer = new StringBuilder();
    }

    void solve() throws IOException {
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            count = 0;
            for (int number : numbers) {
                dfs(number);
            }
            answer.append(count).append('\n');
        }
    }

    void dfs(int number) {
        if (number > n) {
            return;
        }
        if (number == n) {
            count++;
            return;
        }
        for (int num : numbers) {
            dfs(number + num);
        }
    }
}
