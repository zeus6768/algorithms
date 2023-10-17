package ac.solved.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bj1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 665;
        int count = 0;
        while (true) {
            num++;
            if (String.valueOf(num).contains("666")) {
                count++;
            }
            if (count == N) {
                System.out.println(num);
                break;
            }
        }
    }

}