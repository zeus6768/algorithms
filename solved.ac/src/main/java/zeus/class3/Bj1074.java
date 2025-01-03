package zeus.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1074 {

    int n, r, c;

    public static void main(String[] args) {
        new Bj1074().solve();
    }

    void solve() {
        input();
        int answer = find(n, r, c);
        System.out.println(answer);
    }

    void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        } catch (Exception ignored) {}
    }

    int find(int size, int r, int c) {
        if (size-- == 1) {
            return r * 2 + c;
        }
        int sector;
        int threshold = (int) Math.pow(2, size);
        if (r < threshold && c < threshold) sector = 0;
        else if (r < threshold) sector = 1;
        else if (c < threshold) sector = 2;
        else sector = 3;
        return (int) Math.pow(2, 2 * size) * sector + find(size, r % threshold, c % threshold);
    }
}
