package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;

        int left;
        int bag3 = 0;

        while (n >= bag3*3) {
            left = (n-bag3*3);
            if (left % 5 == 0) answer = Math.min(answer, bag3 + left / 5);
            bag3++;
        }

        if (answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }
}
