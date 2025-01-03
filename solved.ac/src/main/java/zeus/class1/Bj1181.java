package zeus.class1;

import java.io.*;
import java.util.*;

public class Bj1181 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    String word;
    Set<String> words;

    Comparator<String> comparator = (s1, s2) -> {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2);
        }
        return s1.length() > s2.length() ? 1: -1;
    };

    public static void main(String[] args) throws IOException {
        new Bj1181().solve();
    }

    void solve() throws IOException {

        input();

        for (String s : words) {
            bw.write(String.valueOf(s) + '\n');
            bw.flush();
        }

        br.close();
        bw.close();
    }

    void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new TreeSet<>(comparator);
        for (int i = 0; i < N; i++) {
            word = br.readLine();
            words.add(word);
        }
    }
}
