package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj10816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();

        StringTokenizer st;

        int n;
        Map<Integer, Integer> cards;
        int m;

        int key;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        cards = new HashMap<>();
        for (int i = 0; i < n; i++) {
            key = Integer.parseInt(st.nextToken());
            cards.computeIfPresent(key, (k, v) -> v+1);
            cards.putIfAbsent(key, 1);
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            answer.append(cards.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(' ');
        }

        System.out.println(answer);
    }
}
