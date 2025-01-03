package zeus.class1;

import java.io.*;

public class Bj2439 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    StringBuilder stars = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new Bj2439().solve();
    }

    void solve() throws IOException {
        N = Integer.parseInt(br.readLine());

        stars.append(" ".repeat(N));

        for (int i = 1; i <= N; i++) {
            stars.deleteCharAt(0);
            stars.append("*");
            bw.write(stars.toString() + '\n');
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
