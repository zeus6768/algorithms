package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj7568 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder answer = new StringBuilder();

    StringTokenizer st;

    int n;

    int[][] sizes;

    public static void main(String[] args) throws IOException {
        new Bj7568().run();
    }

    void run() throws IOException {
        init();
        solve();
        System.out.println(answer);
    }

    void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        sizes = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sizes[i][0] = Integer.parseInt(st.nextToken());
            sizes[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    void solve() {
        int rank;
        for (int i = 0; i < n; i++) {
            rank = 1;
            for (int j = 0; j < n; j++)
                if (sizes[i][0] < sizes[j][0] && sizes[i][1] < sizes[j][1]) rank++;
            answer.append(rank).append(' ');
        }
    }
}
