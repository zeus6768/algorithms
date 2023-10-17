package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2798 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = Integer.parseInt(st.nextToken());

        int sum;
        int answer = 0;

        for (int i = 0; i < n - 2; i++)
            for (int j = i + 1; j < n - 1; j++)
                for (int k = j + 1; k < n; k++) {
                    sum = cards[i] + cards[j] + cards[k];
                    if (sum <= m && answer < sum) answer = sum;
                }

        System.out.println(answer);
    }
}
