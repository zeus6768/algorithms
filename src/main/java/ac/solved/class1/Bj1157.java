package ac.solved.class1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bj1157 {

    static char REDUNDANT = '?';

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int max = 0;
    Map<Integer, Integer> count = new HashMap<>();

    char[] input;
    char answer;

    public static void main(String[] args) throws IOException {
        new Bj1157().solve();
    }

    void solve() throws IOException {
        input();
        for (int key : input) {
            if (count.containsKey(key)) {
                count.put(key, count.get(key)+1);
            } else {
                count.put(key, 1);
            }
            if (max < count.get(key)) {
                max = count.get(key);
                answer = (char) key;
            } else if (max == count.get(key)) {
                answer = REDUNDANT;
            }
        }
        output();
    }

    void input() throws IOException {
        input = br.readLine().toUpperCase().toCharArray();
    }

    void output() throws IOException {
        bw.write(answer);
        bw.close();
    }
}
