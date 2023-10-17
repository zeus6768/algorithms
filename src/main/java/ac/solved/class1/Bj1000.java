package ac.solved.class1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj1000 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    int A, B;

    public static void main(String[] args) throws IOException {
        new Bj1000().solve();
    }

    void solve() throws IOException {
        input();
        output();
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken()) ;
        B = Integer.parseInt(st.nextToken()) ;
    }

    void output() throws IOException {
        bw.write(String.valueOf(A+B));
        bw.close();
    }
}
