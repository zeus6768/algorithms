package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Bj10815 {

    int n;
    Set<Integer> cards;

    int m;
    List<Integer> inputCards;

    Object answer;

    void run() {
        init();
        solve();
        output();
    }

    void init() {
        try (final var reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            var splitter = new StringTokenizer(reader.readLine());
            cards = new HashSet<>();
            while (splitter.hasMoreTokens()) {
                var card = Integer.parseInt(splitter.nextToken());
                cards.add(card);
            }
            m = Integer.parseInt(reader.readLine());
            splitter = new StringTokenizer(reader.readLine());
            inputCards = new ArrayList<>();
            while (splitter.hasMoreTokens()) {
                var card = Integer.parseInt(splitter.nextToken());
                inputCards.add(card);
            }
        } catch(IOException ignored) {}
    }

    void solve() {
        answer = inputCards.stream()
                .map(card -> cards.contains(card) ? 1 : 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    void output() {
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new Bj10815().run();
    }
}
