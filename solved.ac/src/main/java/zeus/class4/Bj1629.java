package zeus.class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long a = Integer.parseInt(tokenizer.nextToken());
        long b = Integer.parseInt(tokenizer.nextToken());
        long c = Integer.parseInt(tokenizer.nextToken());
        long answer = modular(a, b, c);
        System.out.print(answer);
    }

    static long modular(long a, long b, long c) {
        long d = 1;
        long e = a % c;
        while (b > 0) {
            if (b % 2 != 0) {
                d = (d * e) % c;
            }
            b /= 2;
            e = e * e % c;
        }
        return d;
    }
}
