package ac.solved.class1;

import java.io.*;

public class Bj1259 {

    String input;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String answer;

    public static void main(String[] args) throws IOException {
        new Bj1259().solve();
    }

    void solve() throws IOException {
        while (true) {
            input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            answer = check() ? "yes\n" : "no\n";
            bw.write(answer);
            bw.flush();
        }
        bw.close();
    }

    boolean check() {
        int length = input.length();
        for (int i = 0; i < length/2; i++) {
            if (input.charAt(i) != input.charAt(length-i-1)) {
                return false;
            }
        }
        return true;
    }
}
