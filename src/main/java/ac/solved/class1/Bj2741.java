package ac.solved.class1;

import java.io.*;

class Bj2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) answer.append(i).append('\n');
        bw.write(answer.toString());
        br.close();
        bw.close();
    }
}