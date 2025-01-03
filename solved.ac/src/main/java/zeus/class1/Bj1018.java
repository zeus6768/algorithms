package zeus.class1;

import java.io.*;
import java.util.StringTokenizer;

public class Bj1018 {

    StringTokenizer st;

    int N, M;
    String[] board;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] CHESS_BOARD_1;
    String[] CHESS_BOARD_2;

    String EVEN_ROW = "WBWBWBWB";
    String ODD_ROW = "BWBWBWBW";

    int answer;

    public static void main(String[] args) throws IOException {
        new Bj1018().solve();
    }

    void solve() throws IOException {

        initialize();

        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                String[] tmp = new String[8];
                for (int k = 0; k < 8; k++) {
                    tmp[k] = board[i+k].substring(j, j+8);
                }
                answer = Math.min(answer, check(tmp));
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }

    void initialize() throws IOException {

        input();

        CHESS_BOARD_1 = new String[8];
        CHESS_BOARD_2 = new String[8];

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                CHESS_BOARD_1[i] = EVEN_ROW;
                CHESS_BOARD_2[i] = ODD_ROW;
            } else {
                CHESS_BOARD_1[i] = ODD_ROW;
                CHESS_BOARD_2[i] = EVEN_ROW;
            }
        }

        answer = Integer.MAX_VALUE;
    }

    void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        br.close();
    }

    int check(String[] target) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                count1 += (target[i].charAt(j) != CHESS_BOARD_1[i].charAt(j)) ? 1 : 0;
                count2 += (target[i].charAt(j) != CHESS_BOARD_2[i].charAt(j)) ? 1 : 0;
            }
        }
        return Math.min(count1, count2);
    }
}
