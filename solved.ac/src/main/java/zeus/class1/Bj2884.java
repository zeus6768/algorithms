package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

class Bj2884 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    int H, M;
    int minutes;

    int h, m;
    String answer;

    public static void main(String[] args) throws IOException {
        new Bj2884().solve();
    }

    void solve() throws IOException {
        input();
        minutes = (H * 60 + M - 45);
        if (minutes >= 0) {
            h = minutes / 60;
            m = minutes % 60;
        } else {
            h = 23;
            m = 60 + minutes;
        }
        answer = h + " " + m;
        output();
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    void output() throws IOException {
        bw.write(answer);
        bw.close();
    }
}
