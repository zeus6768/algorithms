package zeus.class2;

import java.io.*;
import java.util.StringTokenizer;

class Bj1018 {

    final char[] LINE_1 = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
    final char[] LINE_2 = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int answer = 64;

    StringTokenizer st;

    int N, M;
    char[][] board;

    public static void main(String[] args) throws IOException {
        new Bj1018().run();
    }

    void run() throws IOException {
        input();
        solve();
        output();
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
    }

    void solve() {
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                answer = Math.min(answer, getSquareCount(i, j));
            }
        }
    }

    int getSquareCount(int n, int m) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (LINE_1[j] != board[n+i][m+j]) count1++;
                    else if (LINE_2[j] != board[n+i][m+j]) count2++;
                } else {
                    if (LINE_2[j] != board[n+i][m+j]) count1++;
                    else if (LINE_1[j] != board[n+i][m+j]) count2++;
                }
            }
        }
        return Math.min(count1, count2);
    }

    void output() throws IOException {
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
