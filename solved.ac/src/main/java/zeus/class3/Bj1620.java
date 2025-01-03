package zeus.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bj1620 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n, m;

    Map<Integer, String> numberToName = new HashMap<>();
    Map<String, Integer> nameToNumber = new HashMap<>();

    public static void main(String[] args) throws IOException {
        new Bj1620().run();
    }

    void run() throws IOException {
        init();
        solve();
    }

    void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numberToName.put(i, name);
            nameToNumber.put(name, i);
        }
    }

    void solve() throws IOException {
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                System.out.println(numberToName.get(Integer.parseInt(question)));
            } else  {
                System.out.println(nameToNumber.get(question));
            }
        }
    }
}
