package ac.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Bj2562 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int max = 0;
    int order = 0;

    int number;

    public static void main(String[] args) throws IOException {
        new Bj2562().solve();
    }

    void solve() throws IOException {
        for (int i = 0; i < 9; i++) {
             number = Integer.parseInt(br.readLine());
             if (max < number) {
                 max = number;
                 order = i;
             }
        }
        order++;
        System.out.println(max);
        System.out.println(order);
    }
}
