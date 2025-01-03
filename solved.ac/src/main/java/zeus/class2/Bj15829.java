package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj15829 {

    public static void main(String[] args) throws IOException {

        final long r = 31L;
        final long m = 1234567891L;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        char[] string = br.readLine().toCharArray();

        long alphabet;
        long answer = 0L;

        for (int i = 0; i < l; i++) {
            alphabet = string[i] - 96;
            for (int j = 0; j < i; j++) {
                alphabet = (alphabet * r) % m;
            }
            answer += alphabet;
        }

        System.out.println(answer % m);
    }
}
