package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj1546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        float[] scores = new float[N];

        int max = 0;
        float sum = 0;

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, (int) scores[i]);
        }

        for (int i = 0; i < N; i++) {
            sum += scores[i]/max*100;
        }

        System.out.println(sum/N);
    }
}
