package zeus.class1;

import java.io.*;

public class Bj2438 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    StringBuilder stars = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new Bj2438().solve();
    }

    void solve() throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            stars.append("*");
            output(stars.toString() + '\n');
        }
        br.close();
        bw.close();
    }

    void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    void output(String stars) throws IOException {
        bw.write(stars);
        bw.flush();
    }
}
