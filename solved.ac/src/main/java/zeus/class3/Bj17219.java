package zeus.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Map<String, String> passwords = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(reader.readLine());
            String url = st.nextToken();
            String password = st.nextToken();
            passwords.put(url, password);
        }
        while (m-- > 0) {
            String url = reader.readLine();
            String password = passwords.get(url);
            answer.append(password).append('\n');
        }
        System.out.print(answer);
    }
}
