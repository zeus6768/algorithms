package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int except = (int) Math.round(n*0.15);
        int[] levels = new int[n];
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(levels);
        for (int i = except; i < n-except; i++) {
            answer += levels[i];
        }

        answer = Math.round((float) answer / (n-except*2));

        System.out.println(answer);
    }
}
