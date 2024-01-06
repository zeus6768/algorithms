package ac.solved.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj9375 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder answer = new StringBuilder();;

    public static void main(String[] args) {
        new Bj9375().run();
    }

    void run() {
        int t = Integer.parseInt(input());
        while (t-- > 0) {
            int n = Integer.parseInt(input());
            solve(n);
        }
        System.out.print(answer);
    }

    void solve(int n) {
        Map<String, List<String>> closet = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input());
            String clothes = st.nextToken();
            String category = st.nextToken();
            putClothes(closet, category, clothes);
        }
        appendAnswer(closet);
    }

    void putClothes(Map<String, List<String>> closet, String category, String clothes) {
        if (!closet.containsKey(category)) {
            closet.put(category, new ArrayList<>());
        }
        closet.get(category).add(clothes);
    }

    void appendAnswer(Map<String, List<String>> closet) {
        int numberOfCases = getNumberOfCases(closet);
        answer.append(numberOfCases).append('\n');
    }

    int getNumberOfCases(Map<String, List<String>> clothes) {
        int result = 1;
        for (List<String> names : clothes.values()) {
            result *= names.size() + 1;
        }
        return result - 1;
    }

    String input() {
        try {
            return br.readLine();
        } catch (IOException ignored) {}
        return "";
    }
}
