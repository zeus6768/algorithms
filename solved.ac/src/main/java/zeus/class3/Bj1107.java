package zeus.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1107 {

    int n, m;
    boolean[] isBroken = new boolean[10];

    int answer;

    public static void main(String[] args) {
        new Bj1107().solve();
    }

    void solve() {
        init();
        getMinPushCount();
        System.out.println(answer);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            if (m != 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < m; i++) {
                    int button = Integer.parseInt(st.nextToken());
                    isBroken[button] = true;
                }
            }
            answer = Math.abs(n - 100);
        } catch (Exception ignored) {}
    }

    void getMinPushCount() {
        for (int i = 0; i <= 999_999; i++) {
            String target = String.valueOf(i);
            int length = target.length();
            boolean isButtonOk = true;
            for (int j = 0; j < length; j++) {
                int button = target.charAt(j) - '0';
                if (isBroken[button]) {
                    isButtonOk = false;
                    break;
                }
            }
            if (isButtonOk) {
                int pushCount = length + Math.abs(n - i);
                answer = Math.min(answer, pushCount);
            }
        }
    }
}
