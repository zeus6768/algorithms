package ac.solved.class1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj2475 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int answer = 0;

    StringTokenizer st;
    int number;

    public static void main(String[] args) throws IOException {
        new Bj2475().solve();
    }

    void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            number = Integer.parseInt(st.nextToken());
            number *= number;
            answer += number;
        }
        answer %= 10;
        output();
    }

    void output() throws IOException {
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
