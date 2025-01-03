package zeus.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1110 {

    int n;
    int answer;

    public static void main(String[] args) {
        new Bj1110().run();
    }

    void run() {
        input();
        solve();
        print();
    }

    void input() {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void solve() {
        answer = 0;
        int result = n;
        do {
            answer++;
            result = newNumberFrom(result);
        } while (result != n);
    }

    int newNumberFrom(int n) {
        int a = n % 10;
        int b = n / 10 + a;
        return a * 10 + b % 10;
    }

    void print() {
        System.out.println(answer);
    }
}
