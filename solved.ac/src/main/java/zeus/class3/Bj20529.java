package zeus.class3;

import static java.util.Map.entry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj20529 {

    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    static final Map<String, Integer> MBTIs = Map.ofEntries(
            entry("ISTJ", 0),
            entry("ISTP", 1),
            entry("ISFJ", 2),
            entry("ISFP", 3),
            entry("INTJ", 4),
            entry("INTP", 5),
            entry("INFJ", 6),
            entry("INFP", 7),
            entry("ESTJ", 8),
            entry("ESTP", 9),
            entry("ESFJ", 10),
            entry("ESFP", 11),
            entry("ENTJ", 12),
            entry("ENTP", 13),
            entry("ENFJ", 14),
            entry("ENFP", 15)
    );

    static final StringBuilder ANSWER = new StringBuilder();

    int[] exists = new int[16];

    int n;
    int distance;

    public static void main(String[] args) {
        new Bj20529().run();
    }

    void run() {
        int t = Integer.parseInt(input());
        while (t-- > 0) {
            solve();
        }
        System.out.print(ANSWER);
    }

    void solve() {
        init();
        find(exists, new Stack<>());
        ANSWER.append(distance).append('\n');
    }

    void init() {
        Arrays.fill(exists, 0);
        n = Integer.parseInt(input());
        StringTokenizer tokenizer = new StringTokenizer(input());
        for (int i = 0; i < n; i++) {
            String mbti = tokenizer.nextToken();
            exists[MBTIs.get(mbti)]++;
        }
        distance = Integer.MAX_VALUE;
    }

    void find(int[] exists, Stack<Integer> mbtis) {
        if (mbtis.size() == 3) {
            distance = Math.min(distance, getDistanceAmong(mbtis));
            return;
        }
        for (int i = 0; i < 16; i++) {
            if (exists[i] != 0) {
                exists[i]--;
                mbtis.add(i);
                find(exists, mbtis);
                exists[mbtis.pop()]++;
            }
        }
    }

    int getDistanceAmong(List<Integer> mbtis) {
        int distance = 0;
        distance += getDistanceBetween(mbtis.get(0), mbtis.get(1));
        distance += getDistanceBetween(mbtis.get(0), mbtis.get(2));
        distance += getDistanceBetween(mbtis.get(1), mbtis.get(2));
        return distance;
    }

    int getDistanceBetween(int mbti1, int mbti2) {
        int result = 0;
        int distance = mbti1 ^ mbti2;
        for (int i = 0; i < 4; i++) {
            result += distance & 1;
            distance >>= 1;
        }
        return result;
    }

    String input() {
        try {
            return READER.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
