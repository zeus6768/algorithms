package zeus.class2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N, M;
        int[] A;
        int number;

        int lower, upper, mid;
        boolean exists;

        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            number = Integer.parseInt(st.nextToken());

            lower = 0;
            upper = N-1;
            exists = false;
            while (lower <= upper) {
                mid = (lower+upper)/2;
                if (A[mid] == number) {
                    exists = true;
                    break;
                } else if (A[mid] < number) lower = mid + 1;
                else upper = mid - 1;
            }

            if (exists) answer.append('1');
            else answer.append('0');
            answer.append('\n');
        }

        System.out.println(answer);
    }
}
