package ac.solved.class1;

import java.io.*;

class Bj2753 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Bj2753().solve();
    }

    void solve() throws IOException {
        int year = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(check(year)));
        br.close();
        bw.close();
    }

    int check(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) ? 1 : 0;
    }
}
