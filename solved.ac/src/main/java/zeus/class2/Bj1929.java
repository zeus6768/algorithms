package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder answer = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[N+1];
        for (int i = 2; i <= N; i++) isPrime[i] = true;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i+i; j <= N; j += i) isPrime[j] = false;
                if (i >= M) answer.append(i).append('\n');
            }
        }

        System.out.println(answer);
    }
}
