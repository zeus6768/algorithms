package zeus.class1;

import java.io.*;

class Bj2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i < 10; i++) System.out.printf("%d * %d = %d%n", N, i, N * i);
    }
}
