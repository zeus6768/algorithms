package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Bj11047 {

    int n;
    int k;

    List<Integer> coins;

    public static void main(String[] args) {
        Bj11047 main = new Bj11047();
        main.init();
        main.solve();
    }

    void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input(br));
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(input(br)));
        }
        coins.sort(Comparator.reverseOrder());
    }

    void solve() {
        int count = 0;
        for (int coin : coins) {
            if (k / coin != 0) {
                count += k / coin;
                k %= coin;
            }
        }
        System.out.println(count);
    }

    String input(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
