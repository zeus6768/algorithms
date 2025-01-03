package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj10250 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st;

    int T;
    int H, W, N;

    int floor;
    int room;

    int output;

    public static void main(String[] args) throws IOException {
        new Bj10250().solve();
    }

    void solve() throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();
            if (N % H == 0) {
                floor = H;
                room = N / H;
            } else {
                floor = N % H;
                room = N / H + 1;
            }
            output = floor * 100 + room;
            output();
        }

        br.close();
        bw.close();
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
    }

    void output() throws IOException {
        bw.write(String.valueOf(output));
        bw.newLine();
    }
}
