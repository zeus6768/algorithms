package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1978 {

    final static int MAX = 1001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) if (isPrimeNumber(Integer.parseInt(st.nextToken()))) answer++;

        System.out.println(answer);
    }

    static boolean isPrimeNumber(int num) {
        boolean[] isPrime = new boolean[MAX];
        for (int i = 2; i < MAX; i++) isPrime[i] = true;
        for (int i = 2; i < Math.sqrt(MAX); i++) {
            if (isPrime[i]) {
                for (int j = i+i; j < MAX; j = j+i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime[num];
    }
}
