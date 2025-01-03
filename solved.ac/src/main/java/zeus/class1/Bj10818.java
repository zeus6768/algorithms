package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

class Bj10818 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int min = 1_000_000;
    int max = -1_000_000;

    StringTokenizer st;
    int N;
    int number;

    public static void main(String[] args) throws IOException {
        new Bj10818().solve();
    }

    void solve() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number = Integer.parseInt(st.nextToken());
            if (min > number) min = number;
            if (max < number) max = number;
        }
        System.out.println(min + " " + max);
    }
}
