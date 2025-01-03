package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] dots = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(st.nextToken());
            dots[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots, (d1, d2) -> {
            if (d1[1] == d2[1])
                return d1[0] - d2[0];
            return d1[1] - d2[1];
        });
        for (int[] xy : dots) {
            answer.append(xy[0]).append(' ').append(xy[1]).append('\n');
        }
        System.out.println(answer);
    }
}
