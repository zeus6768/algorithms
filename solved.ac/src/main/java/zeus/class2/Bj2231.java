package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            if (digitSum(i) == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    static int digitSum(int n) {
        int result = n;
        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
