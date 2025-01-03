package zeus.class1;

import java.io.*;

class Bj2577 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] counts = new int[10];

    int A, B, C;
    char[] result;

    public static void main(String[] args) throws IOException {
        new Bj2577().solve();
    }

    void solve() throws IOException {
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        result = String.valueOf(A*B*C).toCharArray();
        for (char c : result) counts[(int) c - 48]++;
        for (int i : counts) {
            bw.write((char) (i + 48));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
