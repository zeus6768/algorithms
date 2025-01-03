package zeus.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Bj25178 {

    static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    int n;
    String word1;
    String word2;

    String answer;

    void run() {
        init();
        solve();
        output();
    }

    void init() {
        try (final var reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            word1 = reader.readLine();
            word2 = reader.readLine();
        } catch (IOException ignored) {}
    }

    void solve() {
        var condition1 = canRearrange(word1, word2);
        var condition2 = firstAndLastLetterEquals(word1, word2);
        var condition3 = equalsWithoutVowels(word1, word2);
        answer = condition1 && condition2 && condition3 ? "YES" : "NO";
    }

    boolean canRearrange(String word1, String word2) {
        Map<Character, Integer> letters1 = new HashMap<>();
        Map<Character, Integer> letters2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            letters1.merge(word1.charAt(i), 1, Integer::sum);
            letters2.merge(word2.charAt(i), 1, Integer::sum);
        }
        return mapEquals(letters1, letters2);
    }

    boolean mapEquals(Map<Character, Integer> letters1, Map<Character, Integer> letters2) {
        var keyEquals = letters1.keySet().containsAll(letters2.keySet());
        var valueEquals = letters1.keySet()
                .stream()
                .allMatch(key -> Objects.equals(letters1.get(key), letters2.get(key)));
        return keyEquals && valueEquals;
    }

    boolean firstAndLastLetterEquals(String word1, String word2) {
        return word1.charAt(0) == word2.charAt(0)
                && word1.charAt(n - 1) == word2.charAt(n - 1);
    }

    boolean equalsWithoutVowels(String word1, String word2) {
        var noVowel1 = noVowel(word1);
        var noVowel2 = noVowel(word2);
        return noVowel1.equals(noVowel2);
    }

    List<Character> noVowel(String word) {
        var noVowel = new ArrayList<Character>();
        for (int i = 0; i < n; i++) {
            var character = word.charAt(i);
            if (!VOWELS.contains(character)) {
                noVowel.add(character);
            }
        }
        return noVowel;
    }

    void output() {
        System.out.println(answer);
    }

    public static void main(String[] args) {
        new Bj25178().run();
    }
}
