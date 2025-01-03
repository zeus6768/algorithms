package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = a;
            a = b;
            b = (tmp + b) % 10_007;
        }
        return b;
    }
}
