package ac.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bj10871 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder answer = new StringBuilder();

    StringTokenizer st;

    int N, X;
    int a;

    public static void main(String[] args) throws IOException {
        new Bj10871().solve();
    }

    void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a = Integer.parseInt(st.nextToken());
            if (a < X) answer.append(a).append(' ');
        }
        System.out.println(answer);
    }
}
