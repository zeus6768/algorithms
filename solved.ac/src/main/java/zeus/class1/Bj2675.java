package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

class Bj2675 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    int T;
    int R;
    char[] S;

    StringBuilder output;

    public static void main(String[] args) throws IOException {
        new Bj2675().run();
    }

    void run() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            solve();
            output();
        }
        br.close();
        bw.close();
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        S = st.nextToken().toCharArray();
    }

    void solve() {
        output = new StringBuilder();
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < R; j++) {
                output.append(S[i]);
            }
        }
    }

    void output() throws IOException {
        output.append('\n');
        bw.write(output.toString());
    }
}
