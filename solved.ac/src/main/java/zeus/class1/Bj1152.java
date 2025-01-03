package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj1152 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer input;

    public static void main(String[] args) throws IOException {
        new Bj1152().solve();
    }

    void solve() throws IOException {
        input();
        output();
    }

    void input() throws IOException {
        input = new StringTokenizer(br.readLine());
    }

    void output() throws IOException {
        bw.write(String.valueOf(input.countTokens()));
        bw.close();
    }
}
