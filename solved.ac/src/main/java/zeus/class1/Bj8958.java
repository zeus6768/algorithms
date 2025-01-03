package zeus.class1;

import java.io.*;

class Bj8958 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String quiz;

    int T;

    public static void main(String[] args) throws IOException {
        new Bj8958().solve();
    }

    void solve() throws IOException {
        T = integer(input());
        for (int i = 0; i < T; i++) {
            quiz = input();
            int score = 0;
            int repeat = 1;
            for (int j = 0; j < quiz.length(); j++) {
                if (quiz.charAt(j) == 'O') {
                    score += repeat;
                    repeat += 1;
                } else {
                    repeat = 1;
                }
            }
            bw.write(String.valueOf(score));
            bw.newLine();
        }
        bw.close();
    }

    int integer(String s) {
        return Integer.parseInt(s);
    }

    String input() throws IOException {
        return br.readLine();
    }
}
