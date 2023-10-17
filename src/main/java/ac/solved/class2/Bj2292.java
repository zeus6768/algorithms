package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int step = 1;
        int bound = 1;

        while (n > bound) {
            bound += step * 6;
            step++;
        }

        System.out.println(step);
    }
}
