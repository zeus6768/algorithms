package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj1008 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    float a, b;
    double A, B;

    public static void main(String[] args) throws IOException {
        new Bj1008().solve();
    }

    void solve() throws IOException {
        input();
        output();
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()) ;
        b = Integer.parseInt(st.nextToken()) ;
    }

    void output() throws IOException {
        bw.write(String.valueOf(a/b));
        bw.close();
    }
}
