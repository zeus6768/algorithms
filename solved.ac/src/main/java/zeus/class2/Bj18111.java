package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] ground = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;
        int diff;
        for (int h = 0; h <= 256; h++) {
            int time = 0;
            int inventory = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ground[i][j] > h) {
                        diff = ground[i][j] - h;
                        inventory += diff;
                        time += 2 * diff;
                    } else if (ground[i][j] < h) {
                        diff = h - ground[i][j];
                        inventory -= diff;
                        time += diff;
                    }
                }
            }
            if (inventory >= 0 && time <= answerTime) {
                answerTime = time;
                answerHeight = h;
            }
        }
        System.out.printf("%d %d", answerTime, answerHeight);
    }
}
