package zeus.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj4153 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int a, b, c;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == 0 && a == b && b == c) break;
            System.out.println(isRight(a, b, c));
        }
    }

    static String isRight(int x, int y, int z) {
        if (
            Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2) ||
            Math.pow(y, 2) + Math.pow(z, 2) == Math.pow(x, 2) ||
            Math.pow(z, 2) + Math.pow(x, 2) == Math.pow(y, 2)
        ) return "right";
        return "wrong";
    }
}
