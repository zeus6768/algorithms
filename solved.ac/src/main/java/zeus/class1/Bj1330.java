package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj1330 {

    static String LEFT_BIGGER = ">";
    static String RIGHT_BIGGER = "<";
    static String EQUAL = "==";

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    int A, B;
    String answer;

    public static void main(String[] args) throws IOException {
        new Bj1330().solve();
    }

    void solve() throws IOException {
        input();
        if (A > B) answer = LEFT_BIGGER;
        else if (A < B) answer = RIGHT_BIGGER;
        else answer = EQUAL;
        output();
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    void output() throws IOException {
        bw.write(answer);
        bw.close();
    }

}
