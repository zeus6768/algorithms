package ac.solved.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Bj10809 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder answer = new StringBuilder();

    int[] locations = new int[26];

    String S;
    int idx;

    public static void main(String[] args) throws IOException {
        new Bj10809().solve();
    }

    void solve() throws IOException {
        S = br.readLine();
        Arrays.fill(locations, -1);
        for (int i = 0; i < S.length(); i++) {
            idx = (int) S.charAt(i) - 97;
            if (locations[idx] == -1) locations[idx] = i;
        }
        for (int i = 0; i < locations.length; i++) answer.append(locations[i]).append(' ');
        System.out.println(answer.toString());
    }
}
