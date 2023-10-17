package ac.solved.class2;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Bj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return (s1.length() < s2.length()) ? -1 : 1;
        };

        Set<String> words = new TreeSet<>(comparator);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) words.add(br.readLine());
        for (String word : words) {
            bw.write(word);
            bw.newLine();
        }
        bw.close();
    }
}
